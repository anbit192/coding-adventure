#include <algorithm>
#include <cmath>
#include <cstdio>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    int n, q;
    cin >> n;
    vector<int> v;

    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }

    cin >> q;

    for (int i = 0; i < q; ++i) {
        int num;
        cin >> num;

        vector<int>::iterator it = lower_bound(v.begin(), v.end(), num);
        int idx = it - v.begin();

        if (v[idx] != num) {
            cout << "No " << idx << endl;
        } else {
            cout << "Yes " << idx << endl;
        }
    }

    return 0;
}