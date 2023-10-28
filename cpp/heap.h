#ifndef HEAP_H_
#define HEAP_H_

// 约定数组下标从1开始，堆为最小堆
// parent n; left child 2n; right child 2n + 1

void siftdown(int i, int n, int arr[]) {
    if (i * 2 > n) return;
    if (i * 2 + 1 > n) {
        if (arr[i] > arr[i * 2]) {
            int t = arr[i] ^ arr[i * 2];
            arr[i] ^= t;
            arr[i * 2] ^= t;
        }
    } else {
        if (arr[i * 2] < arr[i * 2 + 1]) {
            if (arr[i] > arr[i * 2]) {
                int t = arr[i] ^ arr[i * 2];
                arr[i] ^= t;
                arr[i * 2] ^= t;
                siftdown(i * 2, n, arr);
            }
        } else {
            if (arr[i] > arr[i * 2 + 1]) {
                int t = arr[i] ^ arr[i * 2 + 1];
                arr[i] ^= t;
                arr[i * 2 + 1] ^= t;
                siftdown(i * 2 + 1, n, arr);
            }
        }
    }
}

void siftup(int i, int arr[]) {
    if (i / 2 < 1) return;
    if (arr[i] < arr[i / 2]) {
        int t = arr[i] ^ arr[i / 2];
        arr[i] ^= t;
        arr[i / 2] ^= t;
        siftup(i / 2, arr);
    }
}

int* build(int n, int arr[]) {
    for (int i = n; i > 1; i--) {
        if (arr[i] < arr[i / 2]) {
            int t = arr[i] ^ arr[i / 2];
            arr[i] ^= t;
            arr[i / 2] ^= t;
        }
        siftdown(i, n, arr);
    }
    return arr;
}

#endif
