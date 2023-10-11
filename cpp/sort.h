#ifndef SORT_H_
#define SORT_H_
/**
 * # 桶排序
 * 1. 将元素“快速“放入相应桶中
 * 2. 整理所有桶
 * 
 * # 冒泡排序
 * 1. 每轮冒泡可以冒出一个最大值或最小值
 * 2. 冒泡n轮即排序完成
 * 
 * # 快速排序
 * 1. 选中一个基准点，交换左右元素使基准点的位置正确
 * 2. 分治左右两头
 * *note: right先移动
*/


// bubblesort
void bubblesort(int left, int right, int arr[]) {
    int round = right - left;
    while (round--) {
        for (int j = left; j <= left + round; j++) {
            if (arr[j] > arr[j+1]) {
                int t = arr[j] ^ arr[j+1];
                arr[j] ^= t;
                arr[j+1] ^= t;
            }
        }
    }
}

// quicksort
void quicksort(int left, int right, int arr[]) {
    if (left >= right) return;
    int l = left;
    int r = right;
    int benchmark = l;
    int bm_v = arr[benchmark];

    while (l != r) {
        while (r > l && arr[r] > bm_v) {
            r--;
        }
        while (r > l && arr[l] <= bm_v) {
            l++;
        }
        if (r != l) {
            int t = arr[l] ^ arr[r];
            arr[r] ^= t;
            arr[l] ^= t;
        }
    }
    arr[left] = arr[r];
    arr[r] = bm_v;
    quicksort(left, l - 1, arr);
    quicksort(l + 1, right, arr);
}

#endif