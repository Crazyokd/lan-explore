#include "show-bytes.h"

/* $begin test-show-bytes */
void test_show_bytes(int val) {
    int ival = val;
    float fval = (float) ival;
    int *pval = &ival;
    show_int(ival);
    show_float(fval);
    show_pointer(pval);
}
/* $end test-show-bytes */


// practice 2.5
void simple_show_a() {
    /* $begin simple-show-a */
    int val = 0x87654321;
    byte_pointer valp = (byte_pointer) &val;
    show_bytes(valp, 1); /* A. */
    show_bytes(valp, 2); /* B. */
    show_bytes(valp, 3); /* C. */
    /* $end simple-show-a */
}
void simple_show_b() {
    /* $begin simple-show-b */
    int val = 0x12345678;
    byte_pointer valp = (byte_pointer) &val;
    show_bytes(valp, 1); /* A. */
    show_bytes(valp, 2); /* B. */
    show_bytes(valp, 3); /* C. */
    /* $end simple-show-b */
}


void string_ueg() {
    /* $begin show-ustring */
    const char *s = "ABCDEF";
    show_bytes((byte_pointer) s, strlen(s)); 
    /* $end show-ustring */
}

void string_leg() {
    /* $begin show-lstring */
    const char *s = "abcdef";
    show_bytes((byte_pointer) s, strlen(s)); 
    /* $end show-lstring */
}


void show_twocomp() 
{
/* $begin show-twocomp */
    short x = 12345; 
    short mx = -x; 
    
    show_bytes((byte_pointer) &x, sizeof(short)); 
    show_bytes((byte_pointer) &mx, sizeof(short)); 
/* $end show-twocomp */
}


// 2.2.6
void show_extend() {
    short sx = -12345;
    unsigned short usx = sx;
    int x = sx;
    unsigned ux = usx;

    printf("sx = %d:\t", sx);
    show_bytes((byte_pointer) &sx, sizeof(short));

    printf("usx = %u:\t", usx);
    show_bytes((byte_pointer) &usx, sizeof(unsigned short));

    printf("x = %d:\t", x);
    show_bytes((byte_pointer) &x, sizeof(int));

    printf("ux = %u:\t", ux);
    show_bytes((byte_pointer) &ux, sizeof(unsigned));
}

void show_extend_2() {
    short sx = -12345;
    unsigned uy = sx;   // 等价于 (unsigned) (int) sx

    printf("uy = %u:\t", uy);
    show_bytes((byte_pointer) &uy, sizeof(unsigned));
}


void test_fun() {
    unsigned word;
    int i_word;
    word = 0x00000076;
    printf("fun1(%u) = ", word);
    i_word = fun1(word);
    show_bytes(&i_word, sizeof(int));
    printf("fun2(%u) = ", word);
    i_word = fun2(word);
    show_bytes(&i_word, sizeof(int));

    word = 0x87654321;
    printf("fun1(%u) = ", word);
    i_word = fun1(word);
    show_bytes(&i_word, sizeof(int));
    printf("fun2(%u) = ", word);
    i_word = fun2(word);
    show_bytes(&i_word, sizeof(int));
    
    word = 0x000000c9;
    printf("fun1(%u) = ", word);
    i_word = fun1(word);
    show_bytes(&i_word, sizeof(int));
    printf("fun2(%u) = ", word);
    i_word = fun2(word);
    show_bytes(&i_word, sizeof(int));
    
    word = 0xEDCBA987;
    printf("fun1(%u) = ", word);
    i_word = fun1(word);
    show_bytes(&i_word, sizeof(int));
    printf("fun2(%u) = ", word);
    i_word = fun2(word);
    show_bytes(&i_word, sizeof(int));
}


void float_eg() {
  int x = 3490593;
  float f = (float) x;
  printf("For x = %d\n", x);
  show_int(x);
  show_float(f);

  x = 3510593;
  f = (float) x;
  printf("For x = %d\n", x);
  show_int(x);
  show_float(f);

}


int main(int argc, char *argv[])
{
    int val = 12345;

    if (argc > 1) {
        val = strtol(argv[1], NULL, 0);
        if (argc > 2) {
            printf("calling test_show_bytes\n");
            test_show_bytes(val);
        } else {
            if (val == 1){
                printf("Calling simple_show_a\n");
                simple_show_a();
                printf("Calling simple_show_b\n");
                simple_show_b();
            } else if (val == 2) {
                printf("Calling string_ueg\n");
                string_ueg();
                printf("Calling string_leg\n");
                string_leg();
            } else if (val == 3) {
                printf("calling show_twocomp\n");
                show_twocomp();
            } else if (val == 4) {
                show_extend();  
            } else if (val == 5) {
                show_extend_2();
            } else if (val == 6) {
                test_fun();
            } else{
                printf("Calling float_eg\n");
                float_eg();
            }
        }
    } else {
        printf("calling test_show_bytes use default value\n");
        test_show_bytes(val);
        int x = 0x00000007;
        printf("%d\n", x << 29);
    }
    return 0;
}