#include<stdio.h>
int main(){
    int p1;
    putchar('x');
    while((p1 = fork()) == -1);
    if(p1 == 0){
        putchar('b');
        exit(0);
    }else
        putchar('a');
    putchar('y');
}
