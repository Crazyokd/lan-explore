#include <iostream>
#include "minimum-spanning-tree.h"

int main() {
    Edge edges[5];
    edges[0] = {1, 2, 1};
    edges[1] = {1, 3, 5};
    edges[2] = {1, 4, 2};
    edges[3] = {1, 5, 4};
    edges[4] = {2, 3, 3};
    for (int i = 0; i < 5; i++) {
        std::cout << edges[i].weight << ", ";
    }
    std::cout << std::endl;
    build_min_spanning_tree(5, 5, edges);
    return 0;
}