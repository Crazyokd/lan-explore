#include<unistd.h>
#include<stdio.h>
int main(){
    int p;
    while((p = fork()) == -1);
    if(p == 0)
        execl("./child",0);
    else{
        wait(0);
        exit(0);
    }
}
