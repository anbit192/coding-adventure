#include <deque>
#include <iostream>

using namespace std;

void printKMax(int arr[], int n, int k) {
    // Write your code here.
    deque<int> my_deque;

    for (int i = 0; i <= n - k; ++i) {
        int max = arr[i];
        for (int j = 0; j < k; ++j) {
            my_deque.push_back(arr[j + i]);

            if (my_deque.back() >= max) {
                // my_deque.pop_front();
                max = my_deque.back();
            }
        }

        cout << max << " ";
        my_deque.clear();

        // temp_arr[i] = my_deque.back();
    }
    cout << endl;
}

int main() {

    int t;
    cin >> t;
    while (t > 0) {
        int n, k;
        cin >> n >> k;
        int i;
        int arr[n];
        for (i = 0; i < n; i++)
            cin >> arr[i];
        printKMax(arr, n, k);
        t--;
    }
    return 0;
}