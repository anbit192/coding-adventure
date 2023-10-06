#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <set>
#include <algorithm>
using namespace std;

void query(int type, int value, set<int> &s)
{
    if (type == 1)
    {
        s.insert(value);
    }
    else if (type == 2)
    {
        s.erase(value);
    }
    else if (type == 3)
    {
        set<int>::iterator it = s.find(value);
        if (it != s.end())
        {
            cout << "Yes" << endl;
        }
        else
        {
            cout << "No" << endl;
        }
    }
}

int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int q;

    cin >> q;
    set<int> s;
    for (int i = 0; i < q; i++)
    {
        int type, value;

        cin >> type >> value;
        query(type, value, s);
    }

    return 0;
}
