#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

/*
使用 启发式搜索 解决 八数码问题。
f1 = 错放数字个数
f2 = 所有数字当前位置以最短路径走到正确位置的步数之和
*/

// 上下左右
const vector<int> move_i = {-1, 1, 0, 0};
const vector<int> move_j = {0, 0, -1, 1};

vector<int> answer;

// 给定初始 八数码 输入
void input(vector<int>& eight_digit) {
    // 初始化答案
    answer = {1, 2, 3, 8, 0, 4, 7, 6, 5};

    // 初始化输入
    eight_digit = {2, 8, 3, 1, 0, 4, 7, 6, 5};
}

// 计算 f1 = 错放数字个数
int qifa_f1(vector<int>& eight_digit) {
    int result = 0;

    int size = eight_digit.size();
    for (int i = 0; i < size; i++) {
        if (eight_digit[i] != answer[i]) {
            result++;
        }
    }

    return result;
}

// 计算 f2 = 所有数字当前位置以最短路径走到正确位置的步数之和
int qifa_f2(vector<int> eight_digit) {
    int result = 0;

    int size = eight_digit.size();
    for (int i = 0; i < size; i++) {
        if (eight_digit[i] != answer[i]) {
            int correct_pos = find(answer.begin(), answer.end(), eight_digit[i]) - answer.begin();
            int correct_row = correct_pos / 3;
            int correct_col = correct_pos % 3;
            int cur_row = i / 3;
            int cur_col = i % 3;

            result += abs(correct_row - cur_row) + abs(correct_col - cur_col);
        }
    }
    return result;
}



int qifa_search(vector<int>& eight_digit, int pre_pos) {
    int qifa_next_pos = 0;
    int min_f1 = 9 + 1;
    int min_f2 = 36 + 1;

    int space_pos = find(eight_digit.begin(), eight_digit.end(), 0) - eight_digit.begin();
    int space_row = space_pos / 3;
    int space_col = space_pos % 3;

    for (int i = 0; i < 4; i++) {
        int new_row = space_row + move_i[i];
        int new_col = space_col + move_j[i];

        if (new_row >= 0 && new_row < 3 && new_col >= 0 && new_col < 3) {
            int new_pos = new_row * 3 + new_col;
            if (new_pos == pre_pos) continue;

            swap(eight_digit[space_pos], eight_digit[new_pos]);
            int f1 = qifa_f1(eight_digit);
            int f2 = qifa_f2(eight_digit);
            swap(eight_digit[space_pos], eight_digit[new_pos]);
            if (f1 < min_f1 || (f1 == min_f1 && f2 < min_f2)) {
                min_f1 = f1;
                min_f2 = f2;
                qifa_next_pos = new_pos;
            }
        }
    }

    swap(eight_digit[space_pos], eight_digit[qifa_next_pos]);

    return space_pos;
}

void output() {

}

int main() {
    vector<int> eight_digit;
    input(eight_digit);

    int pre_pos = -1;
    while (qifa_f1(eight_digit) > 0) {
        pre_pos = qifa_search(eight_digit, pre_pos);
        cout << "( ";
        for (int i : eight_digit) {
            cout << i << " ";
        }
        cout << ")" << endl;
    }


    return 0;
}