#include <stdio.h>
#include <cstdlib>

void update(int *a, int *b)
{ // function that takes 2 pointers point to a and b address
    // Complete this function

    int new_a = *a;
    int new_b = *b;

    *a = *a + *b;
    *b = abs(new_a - new_b);
}

int main()
{
    int a, b;
    int *pa = &a, *pb = &b; // declare POINTERS that POINT to varirables a and b 's ADDRESS (&a and &b)

    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}