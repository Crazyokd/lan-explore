#ifndef DISJOINT_SET_H_
#define DISJOINT_SET_H_

// init
void init(int n, int parent[]) {
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
    }
}

int get_parent(int n, int parent[]) {
    if (parent[n] == n) {
        return n;
    } else {
        return parent[n] = get_parent(parent[n], parent);
    }
}
// 合并x和y所在树
bool merge(int x, int y, int parent[]) {
    int p1 = get_parent(x, parent);
    int p2 = get_parent(y, parent);
    if (p1 != p2) {
        parent[p1] = p2;
        return true;
    }
    return false;
}

#endif
