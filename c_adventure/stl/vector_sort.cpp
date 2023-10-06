#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    vector<int> items;
    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        int temp;
        cin >> temp;
        items.push_back(temp);
    }

    sort(items.begin(), items.end());

    for (int item : items)
    {
        cout << item << " ";
    }

    cout << endl;

    return 0;
}
