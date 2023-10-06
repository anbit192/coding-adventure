#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

void format_input(string &line)
{
    line = line.substr(1, line.size() - 2);

    for (int i = 0; i < line.size(); i++)
    {
        if (line[i] == '=')
        {
            line.erase(i + 1, 1);
            line.erase(i - 1, 1);
        }
    }
}

vector<string> input_vector(int number_of_lines)
{
    vector<string> string_vect;

    for (int i = 0; i < number_of_lines; i++)
    {
        string str;
        getline(cin, str);
        format_input(str);
        string_vect.push_back(str);
    }

    return string_vect;
}

void print_vector(vector<string> vect)
{
    for (int i = 0; i < vect.size(); i++)
    {
        cout << vect.at(i) << endl;
    }
}

vector<int> _get_white_space_indexes(string line)
{
    vector<int> indexes;
    for (int i = 0; i < line.size(); i++)
    {
        if (line[i] == ' ')
        {
            indexes.push_back(i);
        }
    }

    return indexes;
}

vector<int> _get_equal_indexes(string line)
{
    vector<int> indexes;
    for (int i = 0; i < line.size(); i++)
    {
        if (line[i] == '=')
        {
            indexes.push_back(i);
        }
    }

    return indexes;
}

vector<string> get_attribute(string &line) // <tag1 attr1 = "abc" attr2 = "def">
{

    vector<string> attributes;

    vector<int> equal_indexes = _get_equal_indexes(line);
    if (equal_indexes.size() == 0)
    {
        return vector<string>();
    }

    for (int index : equal_indexes)
    {
        size_t pos1 = line.rfind(' ', index); // find index of whitespace
        string attribute = line.substr(pos1 + 1, index - pos1 - 1);
        attributes.push_back(attribute);
    }

    return attributes;
}

vector<string> get_value(string &line)
{
    vector<string> values;
    vector<int> equal_indexes = _get_equal_indexes(line);
    if (equal_indexes.size() == 0)
    {
        return vector<string>();
    }

    for (int index : equal_indexes)
    {
        size_t pos2 = line.find(' ', index);
        string value = line.substr(index + 1, pos2 - index - 1);
        value = value.substr(1, value.size() - 2);
        values.push_back(value);
    }

    return values;
}

string get_tag(string &line)
{
    size_t space_index = line.find(' ');
    return line.substr(0, space_index);
}

vector<string> user_input(int q)
{
    vector<string> inputs;
    for (int i = 0; i < q; i++)
    {
        string str;
        getline(cin, str);
        inputs.push_back(str);
    }

    return inputs;
}

map<string, map<string, string>> create_map(vector<string> src_string)
{
    map<string, map<string, string>> custom_map;

    for (string str : src_string)
    {
        vector<string> attributes = get_attribute(str);
        vector<string> values = get_value(str);
        string tag = get_tag(str);

        if (attributes.size() <= 0)
        {
            custom_map[tag];
            continue;
        }

        map<string, string>& temp_map = custom_map[tag];  // Get the map for the current tag

        for (int i = 0; i < attributes.size(); i++) {
            temp_map[attributes[i]] = values[i];  // Add attributes and values to the map for the current tag
        }
    }

    return custom_map;

}

void print_map(const map<string, map<string, string>>& custom_map) {
    for (const auto& entry : custom_map) {
        cout << "Tag: " << entry.first << endl;

        for (const auto& inner_entry : entry.second) {
            cout << "  Attribute: " << inner_entry.first << ", Value: " << inner_entry.second << endl;
        }
    }
}

// void query(vector<string> query_strings, vector<string> src_strings)
// {

//     cout << "===========================" << endl;

//     map<string, map<string, string>> custom_map = create_map(src_strings);

//     cout << "===========================" << endl;

//     for (string q : query_strings)
//     {
//         size_t tilde_indx = q.find('~');
//         size_t dot_indx = q.rfind('.');
//         string tag_query = q.substr(dot_indx + 1, tilde_indx - dot_indx - 1);
//         cout << "QUERY TAG: " << tag_query << endl;

//         string attr_query = q.substr(tilde_indx + 1);

//         bool found = false;

//         for (string src_str : src_strings)
//         {
//             string tag = get_tag(src_str);
//             if (tag == tag_query)
//             {
//                 vector<string> attributes = get_attribute(src_str);
//                 for (int i = 0; i < attributes.size(); i++)
//                 {
//                     if (attributes[i] == attr_query)
//                     {
//                         cout << custom_map[attr_query] << endl;
//                         found = true;
//                         break;
//                     }
//                 }
//             }
//         }

//         if (!found)
//         {
//             cout << "Not Found!" << endl;
//         }
//     }
// }

// int main()
// {
//     /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//     int n, q;
//     cin >> n >> q;
//     cin.ignore();

//     vector<string> src_strings = input_vector(n);
//     vector<string> query_strings = user_input(q);

//     return 0;
// }

int main()
{
    vector<string> vect{"<div class = \"a\" id = \"b\">", "<span mood = \"sad\">"};
    vector<string> queries{"div.span~mood", "div~class", "div.span~abc"};
    format_input(vect.at(0));
    format_input(vect.at(1));

    // cout << vect.at(0) << endl;
    // cout << get_tag(vect.at(1)) << endl;
    // print_vector(get_value(vect.at(0)));

    map<string, map<string, string>> outer_map = create_map(vect);

    print_map(outer_map);

    cout << "================" << endl;
    return 0;
}