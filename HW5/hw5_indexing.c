#include <stdio.h>
#include <time.h>

int main() {
    clock_t start, end;
    double time;

    start = clock();
    for (int i = 0; i < 10000; i++) {
        subscript();
    }
    end = clock();  
    time = ((double) (end - start)) / CLOCKS_PER_SEC; // 0.000001 s
    printf("Time taken with subscripting: %f\n", time);

    start = clock();
    for (int I = 0; I < 10000; I++) {
        pointers();
    }
    end = clock();
    time = ((double) (end - start)) / CLOCKS_PER_SEC; // 0.000000 s
    printf("Time taken with pointers: %f\n", time);

    return 0;
}

void subscript() {
    int arr[15][5] = {0};
    for (int j = 0; j < 5; j++) {
        for (int i = 0; i < 15; i++) {
            arr[i][j];
        }
    }
    return;
}

void pointers() {
    int arr[15][5] = {0};
    for (int j = 0; j < 5; j++) {
        for (int i = 0; i < 15; i++) {
            *(*(arr + i) + j);
        }
    }
    return;
}
