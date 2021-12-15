#include<stdio.h>
#define Time int
#define Max 100
typedef struct process{
    char name[10];
    int priority;
    Time ReachTime;
    Time NeedTime;
    Time UsedTime;
    char state;
}PCB;
int n;
PCB pcb[Max];
int pTime;
void AddProcess(){
    char ch;
    do{
        printf("\nplease input process name");
        scanf("%s",pcb[n].name);
        printf("please input the priority of process");
        scanf("%d",&pcb[n].priority);
        printf("please input the need time of process");
        scanf("%d",&pcb[n].NeedTime);
        pcb[n].ReachTime = n;
        pcb[n].UsedTime = 0;
        pcb[n].state = 'W';
        n++;
        printf("Is continue increase process,Yes(Y),No(N)");
        do{
            ch = getchar();
        }while(ch != 'Y' && ch!='N' && ch != 'n' && ch != 'y');
    }while(ch == 'Y' || ch == 'y');
}
//sort
void sort(){
    int i,j;
    PCB temp;
    for(i = 0;i<n-1;i++){
        for(j = n-2;j>=i;j--){
            if(pcb[j+1].ReachTime<pcb[j].ReachTime){
                temp = pcb[j];
                pcb[j] = pcb[j+1];
                pcb[j+1] =temp;
            }
        }
    }
    for(i = 0;i<n-1;i++){
        for(j = n-2;j>=i;j--){
            if(pcb[j+1].priority>pcb[j].priority){
                temp = pcb[j];
                pcb[j] = pcb[j+1];
                pcb[j+1] = temp;
            }
        }
    }
    if(pcb[0].state!='F')
        pcb[0].state = 'R';
}
void print(){
    int i;
    sort();
    printf("\n process_name priority ReachTime NeedTime Used_Time process_state\n");
    for(i = 0;i<n;i++){
        printf("%8s%8d%8d%10d%10d%10c\n",pcb[i].name,pcb[i].priority,pcb[i].ReachTime,pcb[i].NeedTime,pcb[i].UsedTime,pcb[i].state);
    }
}
void attemper(){
    do{
        if((pcb[0].NeedTime-pcb[0].UsedTime)>pTime){
            pcb[0].UsedTime += pTime;
            pcb[0].priority--;
            pcb[0].state = 'W';
        }else{
            pcb[0].UsedTime = pcb[0].NeedTime;
            pcb[0].priority = -1000;
            pcb[0].state = 'F';
        }
        print();
    }while(pcb[0].state != 'F');
}

char face(){
    char choose;
    printf("\n increase process and attemper process,please type 1");
    printf("\n print process,please type 2");
    printf("\n task over,please type 0");
    printf("\n please choose:");
    do{
        choose = getchar();
    }while(choose != '1' && choose != '2' && choose != '0');
    return choose;
}

void main(){
    char choose;
    n = 0;
    printf("set the time size");
    scanf("%d",&pTime);
    choose = face();
    do{
        if(choose == '1'){
            AddProcess();
            print();
            attemper();
        }
        if(choose == '2'){
            print();
        }
        if(choose == '0'){
            return;
        }
        choose =face();
    }while(1);
}










