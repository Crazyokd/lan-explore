#include "RLineConverter.h"

#include <arpa/inet.h>

#include <iostream>
#include <string.h>
#include <vector>
#include <unordered_map>
#include <fstream>

struct FiberData {
    std::string fiberdesc;
    unsigned int linenum1;
    unsigned int linenum2;
};

#pragma pack(push, 1)
typedef struct line_sdh_tele_code_t {
    unsigned char g2_5 : 4;
    unsigned char g10 : 4;

    unsigned char m155 : 4;
    unsigned char m622 : 4;

    unsigned char m2or1_5 : 3;
    unsigned char m8or6 : 3;
    unsigned char m45 : 2;

    unsigned char reserve0;

} LINECODET;
#pragma pack(pop)

class RLineConverter
{
public:
    RLineConverter();

    /**
     * @return
     *   0  if success
     *   -1 if line2 not find
     *   -2 if line1 not matched
     */
    int getLinestr(unsigned int &line1, unsigned int &line2,
                   unsigned int &line3, std::string &linestr);

private:
    std::unordered_map<unsigned int, FiberData> fiberMap;
};

const std::string fiberFile = "fiber.txt";

RLineConverter::RLineConverter()
{
    std::ifstream file(fiberFile);
    if (!file.is_open()) {
        std::cerr << "open " << fiberFile << " failed, maybe you can use convert to generate it" << std::endl;
        throw("");
    }

    std::string line;
    while (std::getline(file, line)) {
        if (line.size()<=2) {
            continue;
        }
        std::string cleanedLine = line.substr(1, line.size() -2);
        std::string::size_type ppos = 0, npos;
        std::string fiberdesc;
        unsigned int linenum1, linenum2;
        while ((npos = cleanedLine.find(',', ppos)) != std::string::npos) {
            if (ppos == 0) {
                // fiberdesc
                fiberdesc = cleanedLine.substr(ppos+1, npos-ppos-2);
            } else {
                // linenum1
                linenum1 = std::stoul(cleanedLine.substr(ppos, npos-ppos));
            }
            ppos = npos+2;
        }
        if (ppos == 0) {
            continue;
        }
        linenum2 = std::stoul(cleanedLine.substr(ppos));
        fiberMap[linenum2] = {fiberdesc, linenum1};
    }

    // for debug
    // for (const auto &pair : fiberMap) {
    //     std::cout << "linenum2: " << pair.first << std::endl;
    //     std::cout << "fiberdesc: " << pair.second.fiberdesc << std::endl;
    //     std::cout << "linenum1: " << pair.second.linenum1 << std::endl;
    //     std::cout << "------------------------" << std::endl;
    // }

    file.close();
}

int RLineConverter::getLinestr(unsigned int &line1, unsigned int &line2,
                               unsigned int &line3, std::string &linestr)
{
    line1 = ntohl(line1);
    line2 = ntohl(line2);
    auto it = fiberMap.find(line2);
    if (it != fiberMap.end()) {
        if (line1 != it->second.linenum1) {
            return -2;
        }


        linestr = it->second.fiberdesc;
        uint32_t tline3 = ntohl(line3);
        LINECODET *linecode = (LINECODET *)(&tline3);
        int Code155 = 0;
        if (linecode->g2_5 == 0x0f) {
            Code155 = (linecode->m622 - 1) * 4 + linecode->m155;
        } else {
            Code155 = (linecode->g2_5 - 1) * 16 + (linecode->m622 - 1) * 4
                    + linecode->m155;
        }

        linestr.append("@")
            .append(std::to_string(Code155).substr(1))
            .append("VC4");
            // .append("VC4.")
            // .append(std::to_string((int)linecode->m45))
            // .append(std::to_string((int)linecode->m8or6))
            // .append(std::to_string((int)linecode->m2or1_5))
            // .append("E");
    } else {
        return -1;
    }

    return 0;
}

static uint8_t hexCharToByte(char high, char low) {
    uint8_t highNibble = (high >= '0' && high <= '9') ? (high - '0') : (high - 'A' + 10);
    uint8_t lowNibble = (low >= '0' && low <= '9') ? (low - '0') : (low - 'A' + 10);
    return (highNibble << 4) | lowNibble;
}
static RLineConverter converter;

int convert(const unsigned char *pLine, std::string &linestr)
{
    unsigned int line1 = *(unsigned int *)pLine;
    unsigned int line2 = *((unsigned int *)&pLine[4]);
    unsigned int line3 = *((unsigned int *)&pLine[8]);

    return converter.getLinestr(line1, line2, line3, linestr);
}
int convert(const char *pLine, std::string &linestr)
{
    unsigned char line[16];
    for (int i = 0; i < 16; ++i) {
        line[i] = hexCharToByte(pLine[2 * i], pLine[2 * i + 1]);
    }
    return convert(line, linestr);
}

int convert(const unsigned char *pLine, int maxlen, char *out, int outlen)
{
    unsigned int line1 = *(unsigned int *)pLine;
    unsigned int line2 = *((unsigned int *)&pLine[4]);
    unsigned int line3 = *((unsigned int *)&pLine[8]);

    std::string linestr;
    int res = converter.getLinestr(line1, line2, line3, linestr);
    if (res != 0) {
        return res;
    }
    maxlen = maxlen - 1; // retain trailing '\0'
    outlen = linestr.size() < maxlen ? linestr.size() : maxlen;
    strncpy(out, linestr.c_str(), outlen);
    return 0;
}
int convert2(const char *pLine, int maxlen, char *out, int outlen)
{
    unsigned char line[16];
    for (int i = 0; i < 16; ++i) {
        line[i] = hexCharToByte(pLine[2 * i], pLine[2 * i + 1]);
    }
    return convert(line, maxlen, out, outlen);
}

