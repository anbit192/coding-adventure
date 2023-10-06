#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <set>
#include <map>
#include <algorithm>
#include <bits/stdc++.h>
using namespace std;

void query(map<string, int> &m)
{

    int type;
    string key;
    map<string, int>::iterator it = m.find(key);

    cin >> type >> key;

    if (type == 1)
    {
        int value;
        cin >> value;

        if (m.count(key) == 0)
        {
            m[key] = value;
        }
        else
        {
            m[key] += value;
        }
    }
    else if (type == 2)
    {

        if (m.count(key) != 0)
        {
            m[key] = 0;
        }
    }
    else if (type == 3)
    {
        cout << m[key] << endl;
    }
}

int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int q;
    cin >> q;
    map<string, int> m;

    for (int i = 0; i < q; i++)
    {
        query(m);
    }
    return 0;
}
