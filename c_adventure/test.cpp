#include <iostream>
#include <cstdio>
#include <ctime>
#include <windows.h>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

void TestReference()
{
    int number = 5;              // normal variable
    int &ref_number = number;    // reference to 'number'
    int *p_number = &ref_number; // address of ref_number (!= ref_number&)

    cout << number << " " << ref_number << "\n";

    number = 9;
    cout << number << " " << ref_number << "\n";

    ref_number = 192;

    cout << *p_number;
}

class TestStatic
{
public:
    static int something;

public:
    void static DoSomething()
    {
        cout << "shit" << "\n";
    }
};

int TestStatic::something = 9;
int main()
{
    // TestStatic::something = 192;
    // TestStatic::DoSomething();
    // cout << TestStatic::something;

    // long random_seed = time(NULL);

    // srand(random_seed);
    // // vector<int> nums;

    // // int total = 1032;
    // vector<int> totals{151, 156, 137, 176, 143, 139, 157, 263, 268, 136, 172, 164, 166};

    // for (int k = 0; k < 5; k++)
    // {
    //     cout << time(NULL) % 60 << "\n"
    //          << "=========================" << endl;
    //     map<int, int> map_nums;

    //     for (int total_num : totals)
    //     {

    //         for (int j = 0; j < total_num; j++)
    //         {
    //             int mod_num = rand() % 13;
    //             // cout << mod_num <<endl;
    //             // nums.push_back(mod_num);
    //             if (map_nums.find(mod_num) == map_nums.end())
    //             {
    //                 map_nums[mod_num] = 1;
    //             }
    //             else
    //             {
    //                 map_nums[mod_num] = map_nums[mod_num] + 1;
    //             }
    //         }
    //     }

    //     std::vector<int> key, value;

    //     for (std::map<int, int>::iterator it = map_nums.begin(); it != map_nums.end(); ++it)
    //     {
    //         key.push_back(it->first);
    //         value.push_back(it->second);
    //     }

    //     map_nums.clear();

    //     // for (int item : value)
    //     // {
    //     //     cout <<item<<endl;
    //     // }

    //     int sum = 0;

    //     for (int i = 0; i < value.size(); i++)
    //     {
    //         sum += value[i];
    //         cout << value[i] << " " << totals[i] << endl;

    //         float temp = (static_cast<float>(value[i]) / static_cast<float>(totals[i])) * 100;
    //         std::cout << "Key: " << key[i] << " -> " << "Value: " << temp << "%" << std::endl;

    //     }

    //     cout << "=============================" << sum << endl;

    //     // return 0;
    // }

    static int a = 1;
    int* p_a = &a;

    *(p_a)+=1;
    ++a;
    ++a;


    cout << a;

    return 0;
}