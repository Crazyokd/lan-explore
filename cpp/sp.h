#ifndef SP_H_
#define SP_H_

#include <stdlib.h>
#include <string.h>
#include <stdio.h>

// Floyd
void floyd(int n, int* arr[]) {
    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > arr[i][k] + arr[k][j]) 
                    arr[i][j] = arr[i][k] + arr[k][j];
            }
        }
    }
}

// Dijkstra
// 要求无负权边
int dijkstra(int start_point, int end_point, int n, int* arr[]) {
    // 初始化距离数组
    int *distance = (int*)malloc(n * sizeof(int));
    memset(distance, 0x3f3f3f3f, n * sizeof(int));
    // 初始化标记数组
    bool *book = (bool*)malloc(n * sizeof(bool));
    memset(book, 0, n * sizeof(bool));
    // 初始化起点
    distance[start_point] = 0;
    book[start_point] = 1;

    for (int i = 1; i < n; i++) {
        int min = 0x3f3f3f3f;
        int index = -1;
        // 找到最小未标记点
        for (int j = 0; j < n; j++) {
            if (!book[j] && distance[j] < min) {
                min = distance[j];
                index = j;
            }
        }
        book[index] = 1;
        // 更新距离数组
        for (int j = 0; j < n; j++) {
            if (!book[j] && distance[index] + arr[index][j] < distance[j]) {
                distance[j] = distance[index] + arr[index][j];
            }
        }
        // optimize
        if (index == end_point) {
            break;
        }
    }
    int res = distance[end_point];
    free(distance);
    free(book);
    return res;
}


// Bellman-Ford
struct Edge {
    int from;
    int to;
    int weight;
};

int bellman_ford(int start_point, int end_point, int n/* node number */, int m/* edge number */, Edge *edges) {
    // 初始化距离数组
    int *distance = (int*)malloc(n * sizeof(int));
    memset(distance, 0x3f3f3f3f, n * sizeof(int));
    distance[start_point] = 0;

    for (int i = 1; i < m; i++) {
        int is_update = 0;
        for (int j = 0; j < m; j++) {
            if (distance[edges->from] + edges->weight < distance[edges->to]) {
                distance[edges->to] = distance[edges->from] + edges->weight;
                is_update = 1;
            }
        }
        if (!is_update) {
            break;
        }
    }

    // check whether there is a negative cycle
    for (int j = 0; j < m; j++) {
        if (distance[edges->from] + edges->weight < distance[edges->to]) {
            printf("there is a negative cycle\n");
            exit(1);
        }
    }
    int res = distance[end_point];
    free(distance);
    return res;
}

#endif