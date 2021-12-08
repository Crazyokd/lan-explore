#include<stdio.h>
#include<unistd.h>
int main(){
    int I,r,j,k,l,p1,p2,fd[2];
    char buf[50],s[50];
    pipe(fd);
    while((p1=fork()) == -1);
    if(p1 == 0){
        lockf(fd[1],1,0);
        sprintf(buf,"Child process p1 is sending message!\n");
        printf("Child process p1!\n");
        write(fd[1],buf,50);
        lockf(fd[1],0,0);
        sleep(5);
        j = getpid();
        k = getppid();
        printf("p1 %d is weakup.My parent process id is %d.\n",j,k);
        exit(0);
    }else{
        while((p2=fork()) == -1);
        if(p2 == 0){
            lockf(fd[1],1,0);
            sprintf(buf,"Child process p2 is sending message!\n");
            printf("Child process p2!\n");
            write(fd[1],buf,50);
            lockf(fd[1],0,0);
            sleep(5);
            j = getpid();
            k = getppid();
            printf("p2 %d is weakup.My parent process id is %d.\n",j,k);
            exit(0);
        }else{
            I = getpid();
            wait(0);
            if(r=read(fd[0],s,50) == -1)
                printf("can't read pipe.");
            else
                printf("Parent %d:%s\n",l,s);
            wait(0);
            if(r=read(fd[0],s,50) == -1)
                printf("cant's read pipe");
            else 
                printf("Parent %d:%s\n",l,s);
            exit(0);
        }
    }
}
