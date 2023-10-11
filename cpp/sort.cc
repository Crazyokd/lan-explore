#include "sort.h"

#include <time.h>
#include <stdlib.h>

#include <iostream>
#include <fstream>

#define GENERATE_COUNT 1000000
using namespace std;

int main() {
    int arr[GENERATE_COUNT];
    srand((unsigned)time(NULL));
    for (int i = 0; i < GENERATE_COUNT; i++) {
        // cout << rand() % GENERATE_COUNT << ", ";
        arr[i] = rand() % GENERATE_COUNT;
    }
    // bubblesort(0, GENERATE_COUNT - 1, arr);
    quicksort(0, GENERATE_COUNT - 1, arr);
    // write to result file
    ofstream result_f("result.txt", std::ios_base::out | std::ios_base::trunc); 
    for (int e : arr) {
        result_f << e << ", ";
    }
    result_f.close();
    return 0;
}