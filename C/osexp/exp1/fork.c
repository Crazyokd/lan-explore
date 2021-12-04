#include <stdio.h>
int main( ){
    int p1;
    while ((p1=fork()) == -1) ; 
    if (p1 == 0)
        printf("i am child process,my pid is %d !\n",getpid());
    else
        printf("i am parent process!, my pid is %d !\n",getppid());
}

