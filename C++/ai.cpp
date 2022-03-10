#include<iostream>
#include<vector>

using namespace std;

int af=5, bf=4;
int target = 2;
int maxDepth = 20;

struct node {
    int a;
    int b;
    node() {
        a = 0;
        b = 0;
    }
    node(int a, int b) {
        this->a = a;
        this->b = b;
    }
};


void aiDFS(vector<node> cur, vector<vector<node>>& res, int depth){
    int a = cur.back().a;
    int b = cur.back().b;

    // 避免无限循环
    if (depth >= maxDepth || (depth > 0 && a == 0 && b == 0))return;
    // 产生一种结果
    if (a == target){
        res.push_back(cur);
        return;
    }

    vector<node> nodeJudge;
    // 将a倒满
    if (a < af) {
        nodeJudge.push_back(node(af, b));
    }
    // 将b倒满
    if (b < bf) {
        nodeJudge.push_back(node(a, bf));
    }
    // 将a倒空
    if (a > 0) {
        nodeJudge.push_back(node(0, b));
    }
    // 将b倒空
    if (b > 0) {
        nodeJudge.push_back(node(a, 0));
    }
    // 将a倒入b
    if (a > 0 && b < bf) {
        int aa, bb;
        aa =a - (bf - b);
        bb =b + a;
        // 对a、b进行处理
        nodeJudge.push_back(node(aa < 0 ? 0 : aa, bb > bf ? bf : bb));
    }
    // 将b倒入a
    if (b > 0 && a < af) {
        int aa, bb;
        bb =b - (af - a);
        aa =a + b;
        // 对a、b进行处理
        nodeJudge.push_back(node(aa > af ? af : aa, bb < 0 ? 0 : bb));
    }

    // 循环搜索排除重复路径
    for (int i = 0; i < cur.size(); i++) {
        for (int j = 0; j < nodeJudge.size(); j++) {
            if (cur[i].a == nodeJudge[j].a && cur[i].b == nodeJudge[j].b) {
                nodeJudge.erase(nodeJudge.begin() + j);
                j--;
            }
        }
    }

    // DFS
    vector<node> tmp(cur);
    for (int i = 0; i < nodeJudge.size(); i++) {
        tmp.push_back(nodeJudge[i]);
        aiDFS(tmp, res, depth + 1);
        tmp.pop_back();
    }
}

int main(){
    vector<node> cur;
    cur.push_back(node(0, 0));
    vector<vector<node>> res;
    aiDFS(cur, res, 0);

    // 输出结果
    for (int i = 0; i < res.size(); i++) {
        for (int j = 0; j < res[i].size(); j++) {
            cout << res[i][j].a << " " << res[i][j].b << " | ";
        }
        cout << endl;
    }

    cout << "run over!" << endl;
}