#include <stdio.h>

enum Example {
    ONE = 1,
    TWO = 2,
    FOUR = 4,
    EIGHT = 8,
    COUNT = 16,
    VAL = 5
}; 
  
int main() 
{ 
    printf("%d\n", (ONE + TWO));
    printf("%d\n", (FOUR - TWO));
    printf("%d\n", (TWO * EIGHT));
    printf("%d\n", (EIGHT / TWO));

    printf("%d\n", (ONE | TWO));
    printf("%d\n", (TWO & FOUR));
    printf("%d\n", (TWO ^ EIGHT));
    printf("%d\n", (EIGHT << 1));
    printf("%d\n", (EIGHT >> 1));

    int intArray[COUNT];
    int ans = 5 + VAL;

    return 0; 
} 
