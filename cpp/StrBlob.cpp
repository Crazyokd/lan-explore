#include "StrBlob.h"
#include <stdexcept>

using namespace std;

StrBlob::StrBlob(): data(make_shared<vector<string>>())
{

}

StrBlob::StrBlob(initializer_list<string> il) :
    data(make_shared<vector<string>>(il))
{

}

void StrBlob::check(size_type i, const string &msg) const
{
    if (i >= data->size())
        throw out_of_range(msg);
}

string& StrBlob::front()
{
    check(0, "front on empty StrBlob");
    return data->front();
}

string& StrBlob::back()
{
    check(0, "back on empty StrBlob");
    return data->back();
}

void StrBlob::pop_back()
{
    check(0, "pop_back on empty StrBlob");
    data->pop_back();
}

StrBlobPtr StrBlob::begin() { return StrBlobPtr(*this); }
StrBlobPtr StrBlob::end()
{
    auto ret = StrBlobPtr(*this, data->size());
    return ret;
}

/* StrBlobPtr */
std::shared_ptr<std::vector<std::string>>
StrBlobPtr::check(std::size_t i, const std::string &msg) const
{
    auto ret = wptr.lock();
    if (!ret)
        throw std::runtime_error("unbound StrBlobPtr");
    if (i >= ret->size())
        throw std::out_of_range(msg);
    return ret;
}
