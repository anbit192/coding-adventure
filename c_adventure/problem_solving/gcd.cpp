#include <iostream>
#include <vector>
using namespace std;

long gcd(long a, long b) {
	long res = a;
	while (b > 0) {
		res = a % b;
		a = b;
		b = res;
	}

	return a;
}

long lcm(long a, long b) { return (a * b) / gcd(a, b); }


int gcd_arr(vector<int> v) 
{
	int res = v[0];
	for (int i = 1; i < v.size(); ++i) 
	{
		res = gcd(res, v[i]);
	}
	
	return res;
}

long lcm_arr(vector<long> v) 
{
	long res = v[0];
	for (int i = 1; i < v.size(); ++i) 
	{
		res = lcm(res, v[i]);
	}
	
	return res;
}

int main() {
	int res = gcd(36, 16);
	int res2 = lcm(21, 6);
	// long res3 = lcm_arr({100, 99, 98 ,97 ,96 ,95, 94, 93, 92, 91});
	// cout << res << " " << res3 << endl;
}