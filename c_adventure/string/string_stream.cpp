#include <sstream>
#include <vector>
#include <iostream>
using namespace std;

vector<int> parseInts(string str)
{
    // Complete this function
    vector<int> vect;
    stringstream str_stream(str);

    int temp;
    char comma;

    while (str_stream >> temp)
    {
        vect.push_back(temp);
        str_stream >> comma;
    }

    return vect;
}

int main()
{
    string str;
    cin >> str;
    vector<int> integers = parseInts(str);
    for (int i = 0; i < integers.size(); i++)
    {
        cout << integers[i] << "\n";
    }

    return 0;
}