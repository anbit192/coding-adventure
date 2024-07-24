// #include<bits/stdc++.h>
#include <iostream>
#include <algorithm>
using namespace std;

//Define the structs Workshops and Available_Workshops.
//Implement the functions initialize and CalculateMaxWorkshops

struct Workshop 
{
	int start_time;
	int duration;
	int end_time;
	
	bool operator < (const Workshop &workshop)
	{
		return (this->end_time < workshop.end_time);
	}
};

struct Available_Workshops 
{
	int n;
	Workshop* workshops;
	
	Available_Workshops(int n) 
	{
		this->n = n;
		workshops = new Workshop[n];
	}
	
	~Available_Workshops() 
	{
		delete[] workshops;
	}
};

Available_Workshops* initialize(int start_times[], int durations[], int n)
{
	Available_Workshops* workshop_manager = new Available_Workshops(n);
	for (int i = 0; i<n; ++i) 
	{
		Workshop* temp = &(workshop_manager->workshops[i]);
		temp->start_time = start_times[i];
		temp->duration = durations[i];
		temp->end_time = temp->start_time + temp->duration;
	}
	
	return workshop_manager;
	
}

int CalculateMaxWorkshops(Available_Workshops* ptr) {
	// Sort workshops by end time
	sort(ptr->workshops, ptr->workshops + ptr->n);

	int count = 0;
	int last_end_time = 0;

	for (int i = 0; i < ptr->n; ++i) {
		if (ptr->workshops[i].start_time >= last_end_time) {
			++count;
			last_end_time = ptr->workshops[i].end_time;
		}
	}

	return count;
}

int main(int argc, char *argv[]) {
	int n; // number of workshops
	cin >> n;
	// create arrays of unknown size n
	int* start_time = new int[n];
	int* duration = new int[n];

	for(int i=0; i < n; i++){
		cin >> start_time[i];
	}
	for(int i = 0; i < n; i++){
		cin >> duration[i];
	}

	Available_Workshops * ptr;
	ptr = initialize(start_time,duration, n);
	cout << CalculateMaxWorkshops(ptr) << endl;
	return 0;
}
