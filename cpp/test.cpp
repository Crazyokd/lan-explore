#include <iostream>
#include <cstddef>
#include <vector>

using namespace std;

struct Base {};
struct Base1 {int val1;};
struct Base2 {int val2;};
struct Base3 : Base1, Base2 {int val3; int val4;};


struct Vir {
    virtual void func() {}
};

typedef struct {
    char begin;
    char data[0];
} abc;
int main()
{
    // 获取 value 成员的偏移量
    // size_t offset = offsetof(Base1, val1);
    // std::cout << "Offset of value: " << offset << " bytes" << std::endl; // 0

    size_t offset = offsetof(Base3, val3);
    std::cout << "Offset of value: " << offset << " bytes" << std::endl; // 8
    offset = offsetof(Base3, val4);
    std::cout << "Offset of value: " << offset << " bytes" << std::endl; // 12

    cout << sizeof(Base) << endl; // 1
    cout << sizeof(Base1) << endl; // 4

    cout << sizeof(Vir) << endl; // 8
    
    cout << sizeof(abc) << endl;

    vector<int> vec;
    vec.push_back(1);
    return 0;
}
