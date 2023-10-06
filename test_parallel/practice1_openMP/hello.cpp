#include <omp.h>
#include <stdio.h>
#include <stdlib.h>

int main()
{

    #pragma omp parallel 
    {
        int thread_id = omp_get_thread_num();
        printf("HELLO WORLD FROM THREAD %d\n", thread_id);
    }

    return 0;
}