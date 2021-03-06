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

/* Determine whether arguments can be added without overflow */
int add_ok(unsigned x, unsigned y);

/* Determine whether arguments can be added without overflow */
int tadd_ok(int x, int y);

/* Determine whether arguments can be subtracted without overflow */
int tsub_ok(int x, int y);

int div16(int x);

#endif