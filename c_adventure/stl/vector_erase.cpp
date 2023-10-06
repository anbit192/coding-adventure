#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n;
    cin >> n;

    vector<int> vect;

    for (int i = 0; i < n; i++)
    {
        int temp;
        cin >> temp;
        vect.push_back(temp);
    }

    int q1;
    cin >> q1;
    q1 -= 1;

    vect.erase(vect.begin() + q1);

    int q2, q3;
    cin >> q2 >> q3;
    q2 -= 1;
    q3 -= 1;

    vect.erase(vect.begin() + q2, vect.begin() + q3);

    cout << vect.size() << endl;
    for (int item : vect)
    {
        cout << item << " ";
    }

    cout << endl;

    return 0;
}
