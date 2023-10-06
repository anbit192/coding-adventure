#include <iostream>
#include <string>
using namespace std;

int main() {
	// Complete the program
    string a, b, new_a, new_b;
    cin >> a >> b;

    new_a = a;
    new_b = b;

    char temp = new_a[0];
    new_a[0] = new_b[0];
    new_b[0] = temp;


    cout << a.size() << " " << b.size() << endl;
    cout << a + b << endl;
    cout << new_a << " " << new_b << endl;
 
  
    return 0;
}