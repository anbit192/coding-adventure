#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <sstream>
#include <iomanip>
using namespace std;




string format_a(double num)
{
    string temp = to_string(num);
    size_t pos = temp.find('.');

    int decimal_part = stoi(temp.substr(0, pos));

    stringstream ss;
    ss << "0x" << hex << decimal_part;


    return ss.str();
}

double round_to(double value, double precision = 0.01)
{
    return round(value / precision) * precision;
}

string format_b(double num)
{
    double rounded = round_to(num);
    stringstream ss;
    ss << fixed << setprecision(2) << rounded;
    string temp = ss.str();
    string res = "";
    for (int i = 0; i < 15 - temp.size() - 1; i++)
    {
        res += "_";
    }
    if (rounded > 0)
    {
        res += "+";
    }
    res += temp;

    return res;
}

string format_c(double num)
{
    stringstream ss;
    ss << uppercase << setprecision(9) << scientific << noshowpos << num;

    return ss.str();
}


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    double a, b, c;
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> a >> b >> c;

        cout << format_a(a) << endl;
        cout << format_b(b) << endl;
        cout << (format_c(c)) << endl;
    }
    
    return 0;
}


