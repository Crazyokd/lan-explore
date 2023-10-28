#ifndef MINIMUM_SPANNING_TREE_H_
#define MINIMUM_SPANNING_TREE_H_

// 无向图转最小生成树

#include "disjoint-set.h"
#include <stdlib.h>
#include "common.h"
#include <algorithm>
#include <iostream>


int build_min_spanning_tree(int n, int m, Edge edges[]) {
    int *parent = (int*)malloc(n * sizeof(int));
    init(n, parent);

    std::sort(edges, edges + m, [](Edge a, Edge b) {
        return a.weight < b.weight;
    });
    int cost = 0;
    int used_edge_num = 0;
    for (int i = 0; i < m; i++) {
        if (merge(edges[i].from, edges[i].to, parent)) {
            cost += edges[i].weight;
            used_edge_num++;
        }
        if (used_edge_num == n - 1) {
            break;
        }
    }
    free(parent);
    return cost;
}


#endif
