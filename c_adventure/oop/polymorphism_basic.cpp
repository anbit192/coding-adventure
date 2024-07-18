#include <algorithm>
#include <cmath>
#include <cstdio>
#include <iostream>
#include <vector>

using namespace std;
static int cur_id = 1;

class Person {
  protected:
    string name;
    int age;
    int cur_id;

  public:
    virtual void getdata(){};

  public:
    virtual void putdata(){};
};

class Professor : public Person {
  private:
    int publications;

  public:
    void getdata() {
        cout << this->name << " " << this->age << " " << this->publications
             << " " << this->cur_id << endl;
    }

  public:
    void putdata() {
        string name;
        int age, publications;
        cin >> name >> age >> publications;

        int *p_id = &::cur_id;
        this->name = name;
        this->age = age;
        this->publications = publications;
        this->cur_id = (*p_id)++;
    }
};

class Student : public Person {
  private:
    const static int size = 6;
    int marks[size];

  public:
    void getdata() {
        int sum = 0;
        for (int i = 0; i < Student::size; ++i) {
            sum += this->marks[i];
        }

        cout << this->name << " " << this->age << " " << sum << " "
             << this->cur_id << endl;
    }

  public:
    void putdata() {
        string name;
        int age;
        // int marks[6];

        cin >> name >> age;
        for (int i = 0; i < Student::size; ++i) {
            cin >> this->marks[i];
        }

        int *p_id = &::cur_id;
        this->name = name;
        this->age = age;
        // this->marks = marks;
        this->cur_id = (*p_id)++;
    }
};

int main() {

    int n, val;
    cin >> n; // The number of objects that is going to be created.
    Person *per[n];

    for (int i = 0; i < n; i++) {

        cin >> val;
        if (val == 1) {
            // If val is 1 current object is of type Professor
            per[i] = new Professor;
        } else
            per[i] = new Student; // Else the current object is of type Student

        per[i]->getdata(); // Get the data from the user.
    }

    for (int i = 0; i < n; i++)
        per[i]->putdata(); // Print the required output for each object.

    return 0;
}
