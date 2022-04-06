#ifndef SHOW_BYTES_H
#define SHOW_BYTES_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef unsigned char *byte_pointer;

void show_bytes(byte_pointer start, size_t len);

void show_int(int x);

void show_float(float x);

void show_pointer(void *x);

int fun1(unsigned word);
int fun2(unsigned word);

#endif