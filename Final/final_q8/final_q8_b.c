#include <stdio.h>

int main() {

    int j = -3;

    for (int i = 0; i < 3; i++) {

        int temp = j + 2;

        if (temp == 3 || temp == 2) j--;
        else if (temp == 0) j += 2;
        else j = 0;

        if (j > 0) goto A;
        else j = 3 - i;

    }
    
    A: 
    return 0;

}