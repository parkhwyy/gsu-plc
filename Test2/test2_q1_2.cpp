// Using integer variables

#include <iostream>
#include <string>
#include <stdlib.h>
using namespace std;

void TempLevel(int convertedValue);

int main() {

    while (true) {

        int userInput, choice, convertedValue;
        cout << "----------------------------------" << endl;
        cout << "Please enter the choice : " << endl;
        cout << "Enter 1 -- convert from Celsius to Fahrenheit" << endl;
        cout << "Enter 2 -- convert from Fahrenheit to Celsius" << endl;
        cout << "Choice : ";
        cin >> choice;

        switch (choice) {

        case 1:

            cout << "Please enter the Celsius value : ";
            cin >> userInput;
            convertedValue = (userInput * 9 / 5) + 32;
            cout << "Fahrenheit is " << convertedValue << endl;
            TempLevel(userInput);

        break;

        case 2:

            cout << "Please enter the Fahrenheit value : ";
            cin >> userInput;
            convertedValue = (userInput - 32) * 5 / 9;
            cout << "Celsius is " << convertedValue << endl;
            TempLevel(convertedValue);

        break;

        default:

            cout << "Invalid Option" << endl;
            exit(0);

        break;

        }

    }

}

void TempLevel(int convertedValue) {

string result;

convertedValue <= 15 ? result = "Temperature is low" : "";
convertedValue > 15 && convertedValue <= 30 ? result = "Temperature is normal" : "";
convertedValue > 30 && convertedValue <= 45 ? result = "Temperature is high" : "";
convertedValue > 45 ? result = "Temperature is extemely high" : "";

cout << result << endl;

}
