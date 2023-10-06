#include <iostream>
#include <cstdio>
using namespace std;

/*
Add `int max_of_four(int a, int b, int c, int d)` here.
*/

int max_of_four(int a, int b, int c, int d) 
{
    int array_int[] = {a, b, c, d};
    int max = array_int[0];
    for (int i = 0; i < 4; i++) {
        if (array_int[i] > max) {
            max = array_int[i];
        }
    }

    return max;
}


int main() {
    int a, b, c, d;
    scanf("%d %d %d %d", &a, &b, &c, &d);
    int ans = max_of_four(a, b, c, d);
    printf("%d", ans);
    
    return 0;
}