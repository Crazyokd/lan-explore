#include "cache-opt.h"

#include <unistd.h>

#include <algorithm>
#include <list>
#include <string>
#include <unordered_map>

using std::list;
using std::string;
using std::unordered_map;

typedef struct ud {
} ud_t;

/* 模拟耗时长的db/disk操作 */
ud_t *query_ud_from_db(std::string &key)
{
    usleep(10);
    return new ud_t;
}

template <typename T>
class cacheOpt final
{
public:
    T *get_ud(std::string &key)
    {
        inner_ud *iud = _kvMap[key];
        if (!iud) {
            return nullptr;
        }
        ++iud->_ref_cnt;
        return iud->_ud;
    }
    void cache_ud(std::string &key, T *v)
    {
        inner_ud *iud = new inner_ud{key, v, 1};
        _kvMap[key] = iud;
        _list.push_front(iud);

        if (_list.size() > _capacity) {
            expire_ud();
        }
    }
    int expire_ud()
    {
        auto size = _list.size();
        /* calculate threshold */
        int threshold = _list.front()->_ref_cnt;
        _mark = std::min(_list.size() / 2, (size_t)_mark);
        auto it = _list.begin();
        ++it;
        for (int i = 1; i < _mark; i++) {
            threshold = std::min((std::uint32_t)threshold, (*it)->_ref_cnt);
            ++it;
        }

        /* do not use remove_if becase the remove_if will iterate all elements */
        /* expire all element which below threshold */
        int expire_cnt = 0;
        for (; it != _list.end();) {
            if ((*it)->_ref_cnt <= threshold) {
                /* expire */
                _kvMap.erase((*it)->_key);
                delete (*it)->_ud;
                delete (*it);
                it = _list.erase(it);
                ++expire_cnt;
            } else {
                ++it;
            }
        }
        /* update mark */
        if (expire_cnt > size / 2) {
            _mark /= 1.5;
        } else if (expire_cnt < size / 5) {
            _mark *= 1.5;
        }
        return expire_cnt;
    }
    ~cacheOpt()
    {
        std::remove_if(_list.begin(), _list.end(), [this](inner_ud *iud) {
            _kvMap.erase(iud->_key);
            delete iud->_ud;
            delete iud;
            return true;
        });
    }
    cacheOpt() : _capacity(100) {}

private:
    struct inner_ud {
        std::string _key;
        T *_ud;
        std::uint32_t _ref_cnt;
    };
    unordered_map<string, inner_ud *> _kvMap;
    list<inner_ud *> _list;
    std::uint32_t _mark;
    const int _capacity;
};

static cacheOpt<ud_t> co;

ud_t *query_ud_from_cache(std::string &key)
{
    ud_t *ud = co.get_ud(key);
    if (!ud) {
        /* get ud from db and cache it */
        ud = query_ud_from_db(key);
        co.cache_ud(key, ud);
    }
    return ud;
}

int main()
{
    std::string key = "12345";
    /**
     * 两组对照：
     * 1. 使用cache-opt
     * 2. 不使用cache-opt
     */
    const int exec_cnt = 100;
    for (int i = 0; i < exec_cnt; i++) {
        query_ud_from_db(key);
    }
    for (int i = 0; i < exec_cnt; i++) {
        query_ud_from_cache(key);
    }
}
