#include<iostream>
using namespace std;



void input_array(int *array)
{
    int usr_input;
    for (int i = 0; i < 5; i++) {
        cin >> usr_input;
        array[i] = usr_input;
    }
}


int main() 
{
    cout << "Hello World" << endl ; // prints Hello World

    int array[5];

    input_array(array);

    for (int i = 0; i < 5; i++) {
        printf("%d ", array[i]);
    }

    return 0;

}