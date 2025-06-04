#include <stdlib.h>
#include <pthread.h>

void *child_thread(void *args) {
    // child thread exits immediately.
    // while (1);
    return (void*)666;
}

int main() {
    pthread_t t1;

    pthread_create(&t1, NULL, child_thread, NULL);

    while(1);
    // parent and child never join.
    // pthread_join(t1, NULL);
}
