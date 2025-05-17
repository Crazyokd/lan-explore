#include <iostream>

#include "RLineConverter.h"

void testConverter(unsigned char *linename)
{
    std::string linestr;
    int res = convert(linename, linestr);
    if (res != 0) {

        std::cout << "parse "
                  << "failed" << std::endl;
    } else {
        std::cout << linestr << std::endl;
    }
}
void testConverter2(char *linename)
{
    std::string linestr;
    int res = convert(linename, linestr);
    if (res != 0) {
        std::cout << "parse "
                  << "failed" << std::endl;
    } else {
        std::cout << linestr << std::endl;
    }
}
int main()
{
    // 字节数组版本
    unsigned char linename1[17] = {
        0x02, 0x08, 0x00, 0x00, 0xfa, 0x08, 0xc8, 0x05, 0xf0,
        0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
    };
    unsigned char linename2[17] = {
        0x02, 0x08, 0x00, 0x00, 0xfa, 0x08, 0xc0, 0x05, 0xf0,
        0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
    };
    unsigned char linename3[17] = {
        0x02, 0x08, 0x00, 0x00, 0xfa, 0x10, 0xd2, 0x05, 0x00,
        0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
    };
    testConverter(linename1);
    testConverter(linename2);
    testConverter(linename3);

    // 字符串版本
    char line1[] = "0x02080000fa08c805f000000000000000";
    char line2[] = "0x02080000fa08c005f000000000000000";
    char line3[] = "0x02080000fa10d2050000000000000000";
    testConverter2(line1+2); // skip `0x`
    testConverter2(line2+2);
    testConverter2(line3+2);
}

