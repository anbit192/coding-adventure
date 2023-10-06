#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n, q;

    cin >> n >> q;
    cout << "n: " << n << endl;
    cout << "q: " << q << endl;

    int **array_container = new int *[n]; // create a POINTER arrays that contain POINTERS to another array (address of address = pointer of pointer)

    for (int i = 0; i < n; i++)
    {
        int k;
        cin >> k;
        cout << "k: " << k << endl;
        int *inner_array = new int[k]; // int inner_array[k] != int *inner_array = new int[k]
        array_container[i] = inner_array;

        for (int j = 0; j < k; j++)
        {
            cin >> array_container[i][j];
        }
    }


    for (int k = 0; k < q; k++)
    {   
        int i, j;
        cin >> i >> j;
        cout << array_container[i][j] << endl; 
    }

    return 0;
}