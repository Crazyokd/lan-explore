#include <cstring>
#include <iostream>

using namespace std;

class test {
    friend test foo(double);
public:
    test() {
        // cout << "cnt: %d" << ++cnt << std::endl;
        memset(array, 0, 100 *sizeof(double));
    }
    // test(const test &t) {
    //     memcpy(this, &t, sizeof(test));
    // }
private:
    double array[100];
    static int cnt;
};

int test::cnt = 0;
test foo(double val)
{
    test local;
    
    local.array[0] = val;
    local.array[99] = val;

    return local;
}

int main()
{
    for (int i = 0; i < 100000000; i++) {
        test t = foo(double(i));
    }
    return 0;
}
