#include <omp.h>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;


int *sum(int *array1, int *array2)
{

    int *array3 = new int[5];


    omp_set_num_threads(10);
    #pragma omp parallel 
    {
        int thread_id = omp_get_thread_num();
        array3[thread_id] = array1[thread_id] + array2[thread_id];
        cout << "thread id: " << thread_id << endl;
        cout << "current element of: " << thread_id << array3[thread_id] << " ";
    }
    cout << endl;

    return array3;
    
}


int main()
{

    int array1[] = {1, 2, 3, 4, 5};
    int array2[] = {1, 1, 1, 1, 1};

    int* array3 = sum(array1, array2);

    for (int i = 0; i < 5; i++)
    {
        cout << array3[i] << " ";
    }
    cout << endl;

    return 0;

}