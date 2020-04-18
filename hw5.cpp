#include <iostream>
using namespace std;

enum Example {
    ONE = 1,
    TWO = 2,
    FOUR = 4,
    EIGHT = 8,
    COUNT = 16,
     VAL = 5
};

int main(void) {

    cout << (ONE + TWO) << endl;    // 3
    cout << (FOUR - TWO) << endl;   // 2
    cout << (TWO * EIGHT) << endl;  // 16
    cout << (EIGHT / TWO) << endl;  // 4

    cout << (ONE | TWO) << endl;    // 3
    cout << (TWO & FOUR) << endl;   // 0
    cout << (TWO ^ EIGHT) << endl;  // 10
    cout << (EIGHT << 1) << endl;   // 16
    cout << (EIGHT >> 1) << endl;   // 4

    int intArray[COUNT];  // valid 
    int ans = 5 + VAL; // valid

    return 0;
}