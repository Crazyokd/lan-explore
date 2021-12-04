#include<stdio.h>
int main(){
    int p1;
    while((p1 = fork()) == -1);
    if(p1 > 0){
        wait(0);
        putchar('a');
    }else{
        putchar('b');
        exit(0);
    }
}
