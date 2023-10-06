#include <bits/stdc++.h>
using namespace std;


int main()
{
    int n;
    cin >> n;

    // Write your code here

    string number_string[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    if (n >= 1 && n <= 9) {
        cout << number_string[n - 1] << endl;
    } else {
        cout << "Greater than 9" << endl;
    }

    return 0;
}