#include<stdio.h>
#include<unistd.h>
int main(){
    int p1,fd[2];
    char outpipe[50];
    char inpipe[50]="This is a message!";
    pipe(fd);
    while((p1=fork()) == -1);
    if(p1 == 0){
        write(fd[1],inpipe,50);
        exit(0);
    }else{
        wait(0);
        read(fd[0],outpipe,50);
        printf("%s\n",outpipe);
        exit(0);
    }
}
