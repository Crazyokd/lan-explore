#include<iostream>
#include<vector>
using namespace std;

/*
井字棋模拟
f 为 (空格全为X时答案数) - (空格全为O时答案数)
*/

// 统计答案
int cal(vector<int>& jingzi_cheese, int v) {
    int result = 0;
    int size = jingzi_cheese.size();
    // 横向和纵向
    for (int i = 0; i < size/3; i++) {
        // 横向
        int real_row_begin = i * 3;
        if (jingzi_cheese[real_row_begin] == v && jingzi_cheese[real_row_begin] == jingzi_cheese[real_row_begin+1]
            && jingzi_cheese[real_row_begin] == jingzi_cheese[real_row_begin+2]) {
            result ++;        
        }
        // 纵向
        if (jingzi_cheese[i] == v && jingzi_cheese[i] == jingzi_cheese[i+3]
            && jingzi_cheese[i] == jingzi_cheese[i+6]) {
                result ++;
        }
    }

    // 交叉
    if (jingzi_cheese[0] == v && jingzi_cheese[0] == jingzi_cheese[4]
        && jingzi_cheese[0] == jingzi_cheese[8]) {
            result ++;
    }
    if (jingzi_cheese[2] == v && jingzi_cheese[2] == jingzi_cheese[4]
        && jingzi_cheese[2] == jingzi_cheese[6]) {
            result ++;
    }

    return result;
}
// 计算 f
int cal_f(vector<int> jingzi_cheese, int v) {
    // 初始化
    int size = jingzi_cheese.size();
    for (int i = 0; i < size; i++) {
        if (jingzi_cheese[i] == -1) {
            jingzi_cheese[i] = v;
        }
    }

    return cal(jingzi_cheese, v);    
}

void boyi(vector<int>& jingzi_cheese) {
    int size = jingzi_cheese.size();
    int minf = 0x80000000;
    int next_pos = -1;
    int defeat = -1;

    for (int i = 0; i < size; i++) {
        if (jingzi_cheese[i] == -1) {
            // 尝试放置X
            jingzi_cheese[i] = 1;
            if (cal(jingzi_cheese, 1)) {
                // 直接胜利
                return;                
            }
            int cmp = cal_f(jingzi_cheese, 1) - cal_f(jingzi_cheese, 0);
            if (cmp == minf) {
                jingzi_cheese[i] = 0;
                if (cal(jingzi_cheese, 0)) {
                    // 不进行拦截将直接失败
                    defeat = i;
                }
                jingzi_cheese[i] = 1;
            }
            if (cmp > minf) {
                minf = cmp;
                next_pos = i;
            }
            jingzi_cheese[i] = -1;
        }
    }

    next_pos = defeat != -1 ? defeat : next_pos;
    jingzi_cheese[next_pos] = 1;
}

// 判断游戏是否结束
bool judge(vector<int>& jingzi_cheese) {
    bool is_over = false;
    
    int i;
    for (i = 0; i < jingzi_cheese.size(); i++) {
        if (jingzi_cheese[i] == -1) {
            break;
        }
    }
    if (i == jingzi_cheese.size()) {
        cout << "平局！\n";
        is_over = true;
    }

    if (!is_over && cal(jingzi_cheese, 1)) {
        cout << "对方获胜！\n";
        is_over = true;
    }

    if (!is_over && cal(jingzi_cheese, 0)) {
        cout << "您获胜！\n";
        is_over = true;
    }

    return is_over;
}

int main() {
    // 初始化棋盘
    vector<int> jingzi_cheese(9, -1);

    int size = jingzi_cheese.size();
    int luozi_pos;
    do {
        // 输出棋盘情况
        for (int i = 0; i < size; i++) {
            if (i % 3 == 0) {
                cout << "\n-----------" << endl;
            }

            char output_symbol = ' ';
            if (jingzi_cheese[i] != -1) {
                output_symbol = jingzi_cheese[i] ? 'X' : 'O';
            }
            cout << output_symbol << " | ";
        }
        cout << "\n请输入您的落子位置(索引以1开头)：";
        cin >> luozi_pos;

        // 检查落子位置是否合法
        while (luozi_pos <= 0 || luozi_pos > 9 || jingzi_cheese[luozi_pos - 1] != -1) {
            cout << "\n落子有误，请重新输入您的落子位置(索引以1开头)：";
            cin >> luozi_pos;
        }
        jingzi_cheese[luozi_pos - 1] = 0;

        boyi(jingzi_cheese);
    } while (!judge(jingzi_cheese));

    return 0;
}