#include <iostream>
#include <cstdio>
using namespace std;

void TestReference()
{
    int number = 5; // normal variable
    int& ref_number = number; // reference to 'number'
    int* p_number = &ref_number; // address of ref_number (!= ref_number&)

    cout << number << " " << ref_number << "\n";

    number = 9;
    cout << number << " " << ref_number <<"\n";

    ref_number = 192;

    cout << *p_number;
}

class TestStatic
{
    public:static int something;

    public:void static DoSomething()
    {
        cout << "shit" <<"\n";
    }
};

int TestStatic::something = 9;
int main()
{
    TestStatic::something = 192; 
    TestStatic::DoSomething();
    cout << TestStatic::something;
    return 0;
}