#include <omp.h>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> generate_matrix(int size)
{
    vector<vector<int>> matrix;

    for (int i = 0; i < size; i++)
    {
        vector<int> temp;

        for (int j = 0; j < size; j++)
        {
            if (j <= i)
            {
                temp.push_back(0);
            }
            else
            {
                temp.push_back(1);
            }
        }

        matrix.push_back(temp);
    }

    return matrix;
}

void print_matrix(vector<vector<int>> matrix)
{
    for (vector<int> v : matrix)
    {
        for (int item : v)
        {
            cout << item << "  ";
        }
        cout << endl;
        cout << endl;

    }
}

vector<vector<int>> create_matrix_from_index(int i, int j, vector<vector<int>> source)
{
    vector<vector<int>> new_matrix;
    for (int x = i - 1; x <= i + 1; x++)
    {
        vector<int> temp;

        for (int y = j - 1; y <= j + 1; y++)
        {
            temp.push_back(source[x][y]);
        }

        new_matrix.push_back(temp);
    }

    // print_matrix(new_matrix);

    return new_matrix;
}


int calculate(vector<vector<int>> new_matrix, vector<vector<int>> filter)
{
    int sum = 0;

    
    {
        for (int i = 0; i < new_matrix.size(); i++)
        {
            for (int j = 0; j < new_matrix.size(); j++)
            {
                sum += (new_matrix[i][j] * filter[i][j]);
            }
        
        }
    }



    return sum;
}

vector<vector<int>> apply_filter(vector<vector<int>> matrix, vector<vector<int>> filter_matrix)
{
    vector<vector<int>> filtered_matrix = matrix;

    #pragma omp parallel for
    for (int i = 1; i < filtered_matrix.size() - 1; i++)
    {
        for (int j = 1; j < filtered_matrix.size() - 1; j++)
        {

            int thread_id = omp_get_thread_num();
            vector<vector<int>> temp = create_matrix_from_index(i, j, matrix);
            int value = calculate(temp, filter_matrix);
            cout << "THREAD ID: " << thread_id << endl;

            filtered_matrix[i][j] = value;
        }
    }

    for (int i = 0; i < filtered_matrix.size(); i++)
    {
        for (int j = 0; j < filtered_matrix.size(); j ++)
        {
            if (i == 0 || i == filtered_matrix.size() - 1 || j == 0 || j == filtered_matrix.size() - 1)
            {
                filtered_matrix[i][j] = 0;
            }
        }
    }

    return filtered_matrix;
}

int main()
{
    vector<vector<int>> matrix = generate_matrix(9);
    vector<vector<int>> filter_matrix{
        {0, -1, 0}, {-1, 4, -1}, {0, -1, 0}};

    print_matrix(apply_filter(matrix, filter_matrix));

    return 0;
}