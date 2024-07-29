#include <iostream>
#include <string>
#include <vector>


using namespace std;

/*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

string timeConversion(string s) {

    size_t first_ = s.find(":");
    size_t last_ = s.rfind(":");

    string hr = s.substr(0, first_ - 0);
    string min = s.substr(first_ + 1, last_ - first_ - 1);
    string sec = s.substr(last_ + 1, 2);
    string time = s.substr(8, 2);

    string result = "";

    int hour = stoi(hr);

    if (time.compare("AM") == 0 && hour == 12) {
        result += "00";
    } else if (time.compare("PM") == 0) {
        if (hour == 12 && stoi(min) > 0) {
            result += to_string(hour);
        }
        else {
            int temp = hour + 12;
            result += to_string(temp);
        }

    } else {
        result += hr;
    }

    result = result + ":" + min + ":" + sec;

    return result;
}

// int main()
// {
//     ofstream fout(getenv("OUTPUT_PATH"));

//     string s;
//     getline(cin, s);

//     string result = timeConversion(s);

//     fout << result << "\n";

//     fout.close();

//     return 0;
// }
