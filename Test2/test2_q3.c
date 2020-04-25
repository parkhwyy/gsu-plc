#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void static_fun (void);
void stack_fun (void);
void heap_fun (void);

main (void) {

    struct timespec time1, time2;
    int i;

    clock_gettime(CLOCK_REALTIME, &time1);
    for (i = 0; i < 500000; i++) {
        static_fun();
    }
    clock_gettime(CLOCK_REALTIME, &time2);
    printf("It took %d ns to call static_fun 500,000 times.\n",
        time2.tv_nsec - time1.tv_nsec);

    clock_gettime(CLOCK_REALTIME, &time1);
    for (i = 0; i < 500000; i++) {
        stack_fun();
    }
    clock_gettime(CLOCK_REALTIME, &time2);
    printf("It took %d ns to call stack_fun 500,000 times.\n",
        time2.tv_nsec - time1.tv_nsec);

    clock_gettime(CLOCK_REALTIME, &time1);
    for (i = 0; i < 500000; i++) {
        heap_fun();
    }
    clock_gettime(CLOCK_REALTIME, &time2);
    printf("It took %f s to call heap_fun 500,000 times.\n",
        difftime(time2.tv_sec, time1.tv_sec));
}

void static_fun (void) {
    static int a[250000];
}

void stack_fun (void) {
    int b[250000];
}

void heap_fun (void) {
    int *c = (int *) malloc(250000 * sizeof(int));
}