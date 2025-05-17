#pragma once

#include <string>

/// c++ 接口
/* 16个字节数组 */
int convert(const unsigned char *pLine, std::string &linestr);
/* 32个字符数组 */
int convert(const char *pLine, std::string &linestr);

/// c 接口
/* 16个字节数组 */
extern "C" int convert(const unsigned char *pLine, int maxlen, char *out, int outlen);
/* 32个字符数组 */
extern "C" int convert2(const char *pLine, int maxlen, char *out, int outlen);

