#ifndef _MAJORITY_VOTE_H
#define _MAJORITY_VOTE_H

// invoke with candidate(0, n, arr)
int candidate(int start, int n, int arr[]) {
    int c = arr[start];
    int count = 1;
    int i;
    for (i = start + 1; count > 0 && i < n; i++) {
        if (arr[i] == c) {
            count++;
        } else {
            count--;
        }
    }
    if (count == n - start) {
        return c;
    } else {
        return candidate(i, n, arr);
    }
}

#endif