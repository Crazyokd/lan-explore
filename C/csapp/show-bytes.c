/* $begin show-bytes */
#include "show-bytes.h"

// typedef unsigned char *byte_pointer;

void show_bytes(byte_pointer start, size_t len) {
    size_t i;
    for (i = 0; i < len; i++)
	printf(" %.2x", start[i]);    //line:data:show_bytes_printf
    printf("\n");
}

void show_int(int x) {
    show_bytes((byte_pointer) &x, sizeof(int)); //line:data:show_bytes_amp1
}

void show_float(float x) {
    show_bytes((byte_pointer) &x, sizeof(float)); //line:data:show_bytes_amp2
}

void show_pointer(void *x) {
    show_bytes((byte_pointer) &x, sizeof(void *)); //line:data:show_bytes_amp3
}

int fun1(unsigned word) {
    return (int) ((word << 24) >> 24);
}
int fun2(unsigned word) {
    return ((int) word << 24) >> 24;
}

int add_ok(unsigned x, unsigned y) {
    unsigned sum = x + y;
    return sum >= x;
}

int tadd_ok(int x, int y) {
    return !((x > 0 && y > 0 && x + y < 0) || (x < 0 && y < 0 && x + y > 0));
}

int tsub_ok(int x, int y) {
    return y != 0x80000000 && tadd_ok(x, -y);
}

//2.42
int div16(int x) {
    // 如果x为负数，需要加上15
    int bias = (x >> 31) & 0xF;
    return (x + bias) >> 4;
}
/* $end show-bytes */