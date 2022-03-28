#include<iostream>
#include<string>
#include<vector>
#include<fstream>
#include <windows.h>    // 用于函数SetConsoleOutputCP(65001)

using namespace std;

// 56个 Java 关键字
vector<string> keyWords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
				"class", "const", "continue", "default", "do", "double", "else", "enum", "export", "extends", "final", "fianlly",
				"float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
				"new", "module", "open", "opens", "package", "private", "protected", "provides", "public", "return", "short", "static", "strictfp", "super",
				"switch", "synchronized", "this", "throw", "throws", "transient", "try", "var", "void", "volatile", "while"};

// 算术运算符
vector<string> arithmeticOperations = { "=", "+", "-", "*", "/", "%", "++", "--" };
		
// 关系运算符
vector<string> relationOperations = { "<", ">", "<=", ">=", "==", "!=" };
		
// 位运算符
vector<string> bitOperations = { "&", "|", "^", "~", "<<", ">>", ">>>" };

// 逻辑运算符
vector<string> logicOperations = { "&&", "||", "!" };

//标识符由不是数字开头，$、_、字母（区分大小写）和数字组成（true、false、null和关键字不是标识符）不限长度的字符串。
vector<string> noIdentifier = { "true", "false", "null" };

// 分界符
vector<string> limiterWords = { ".", ",", ";", "[", "]", "{", "}", "(", ")", ":" };

const int keyWordBenchmark = 0;
const int arithmeticBenchmark = keyWordBenchmark + keyWords.size();
const int relationBenchmark = arithmeticBenchmark + arithmeticOperations.size();
const int bitBenchmark = relationBenchmark + relationOperations.size();
const int logicBenchmark = bitBenchmark + bitOperations.size();
const int limiterBenchmark = logicBenchmark + logicOperations.size();


// 判断是否为数字
bool isNumber(string word) {
    if (word[0] < '0' || word[0] > '9') {
        return false;
    }
    if (word[0] == '0') {
        // 十六进制
        if (word[1] == 'x' || word[1] == 'X') {
            for (int i = 2; i < word.length(); i++) {
                if (word[i] < '0' || word[i] > '9') {
                    if (word[i] < 'a' || word[i] > 'f') {
                        if (word[i] < 'A' || word[i] > 'F') {
                            return false;
                        }
                    }
                }
            }
        } else {
            // 八进制
            for (int i = 1; i < word.length(); i++) {
                if (word[i] < '0' || word[i] > '7') {
                    return false;
                }
            }
        }
    } else {
        // 十进制
        for (int i = 1; i < word.size(); i++) {
            if (word[i] > '9' || word[i] < '0') {
                return false;
            }
        }
    }
    return true;
}


//
bool isSpecial(vector<string>& list, string word, int& index) {
    for (int i = 0; i < list.size(); i++) {
        if (list[i] == word) {
            index = i;
            return true;
        }
    }
    return false;
}


void detachlimiter(string& word) {
    for (int i = 0; i < word.size(); i++) {
        for (int j = 0; j < limiterWords.size(); j++) {
            if (word[i] == limiterWords[j][0]) {
                cout << "delimiter\t" << limiterBenchmark + j << "\t" << word[i] << endl;
                word = word.substr(0, i) + " " + word.substr(i + 1);
                i--;
                break;
            }
        }
    }
}

// 分析word
int analyzeWord(string word) {
    int index = -1;
    if (isSpecial(keyWords, word, index) ) {
        cout << "keyword";
        index = keyWordBenchmark + index;
    }else if (isSpecial(arithmeticOperations, word, index)) {
        cout << "ariOpe";
        index = arithmeticBenchmark + index;
    }else if (isSpecial(relationOperations, word, index)) {
        cout << "relaOpe";
        index = relationBenchmark + index;
    }else if (isSpecial(bitOperations, word, index)) {
        cout << "bitOpe";
        index = bitBenchmark + index;
    }else if (isSpecial(logicOperations, word, index)) {
        cout << "logicOpe";
        index = logicBenchmark + index;
    }else if (isNumber(word)) {
        index = -2;
        cout << "number";
    }else {
        cout << "id";
    }
    cout << "\t\t";
    return index;
}


// 处理注释
bool handleComment(string& word, bool comment) {
    int mulLineComStartIndex = word.find("/*");
    int mulLineComEndIndex = word.find("*/");
    int singleLineComStartIndex = word.find("//");

    if (comment) {
        if (mulLineComEndIndex < 0) {
            word = "";
        }else {
            word = word.substr(mulLineComEndIndex + 2);
        }
    }

    // 满足以下条件才认为单行注释有效
    if (singleLineComStartIndex >= 0 && (mulLineComStartIndex < 0 || mulLineComStartIndex > singleLineComStartIndex || (mulLineComEndIndex >= 0 && singleLineComStartIndex > mulLineComEndIndex))) {
        word = word.substr(0, singleLineComStartIndex);
    }
    // 满足以下条件才认为多行注释有效
    if (mulLineComStartIndex >= 0 && (singleLineComStartIndex < 0 || mulLineComStartIndex < singleLineComStartIndex)) {
        // 多行注释
        // word = word.substr(0, mulLineComStartIndex); 
        if (mulLineComEndIndex >= 0) {
            word = word.substr(0, mulLineComStartIndex) + " " + word.substr(mulLineComEndIndex + 2);
        } else {
            word = word.substr(0, mulLineComStartIndex);
            // 注释还有后续
            comment = true;
        }
    }    
    return comment;
}


// 抽取字符串常量【优化：将返回值改为 int 】
bool handleString(string& word, string delimiter) {
    int index_front = word.find(delimiter);
    if (index_front >= 0) {
        int index_back_pre = index_front + 1;
        int index_back = word.find(delimiter, index_back_pre);
        // fix the bugs about escape character
        while(index_back > index_back_pre && word[index_back - 1] == '\\') {
            index_back_pre = index_back + 1;
            index_back = word.find(delimiter, index_back_pre);
        }
        cout << "string\t\t-3\t" << word.substr(index_front, index_back - index_front + 1) << endl;
        word = word.substr(0, index_front) + " " + word.substr(index_back + 1);
        return true;
    }
    return false;
    
}


// 按行分析
void analyzeByLine(vector<string> lines) {
    bool comment = false;
    for (auto line : lines) {
        // 忽略注释
        comment = handleComment(line, comment);
        // 处理字符串常量
        while(handleString(line, "\"") || handleString(line, "'"));

        // 分离分界符
        detachlimiter(line);

        char *cstr = new char[line.length() + 1];
        strcpy(cstr, line.c_str());
        char *p = strtok(cstr, " ");

        // 每行按空格分割
        while (p != NULL) {
            string word(p);

            cout << analyzeWord(word) << "\t" << word << endl;
            p=strtok(NULL, " ");
        }
        delete[] cstr;
    }   
}


// 读取源文件
void readSrcFile(string filePath, vector<string>& lines) {
    // 更改cmd编码为utf8
    SetConsoleOutputCP(65001);
    ifstream in(filePath);
    string line;

    if (in) {
        while (getline (in, line)) { 
            lines.push_back(line);
            // cout << line << endl;
        }
        in.close();
    }
    else {
        cout << "no such file" << endl;
    }

    // system("pause");
}



int main() {
    vector<string> lines;
    readSrcFile("example2.java", lines);
    
    analyzeByLine(lines);

    return 0;
}