#include<iostream>

using namespace std;
// It is guaranteed that new_val has only 2, 3 and 5 as its prime factors.

class A
{
	public:
		A(){
			callA = 0;
		}
	private:
		int callA;
		void inc(){
			callA++;
		}

	protected:
		void func(int & a)
		{
			a = a * 2;
			inc();
		}
	public:
		int getA(){
			return callA;
		}
};

class B
{
	public:
		B(){
			callB = 0;
		}
	private:
		int callB;
		void inc(){
			callB++;
		}
	protected:
		void func(int & a)
		{
			a = a * 3;
			inc();
		}
	public:
		int getB(){
			return callB;
		}
};

class C
{
	public:
		C(){
			callC = 0;
		}
	private:
		int callC;
		void inc(){
			callC++;
		}
	protected:
		void func(int & a)
		{
			a = a * 5;
			inc();
		}
	public:
		int getC(){
			return callC;
		}
};

class D : public A, public B, public C
{
	int val;
	
	public:D(): A(), B(), C()
	{
		val = 1;
	}


	//Implement this function
	public:void update_val(int new_val)
	{
		int total = new_val;
		while (this->val < new_val) 
		{
			if (total % 2 == 0) 
			{
				this->A::func(this->val);
				total/=2;
			} else if (total % 3 == 0) 
			{
				this->B::func(this->val);
				total/=3;
			} else if (total % 5 == 0) 
			{
				this->C::func(this->val);
				total/=5;
			} else 
			{
				break;
			}
		}
		
		this->val = new_val;
	}
		 //For Checking Purpose
		 void check(int); //Do not delete this line.
};



void D::check(int new_val)
{
	update_val(new_val);
	cout << "Value = " << val << endl << "A's func called " << getA() << " times " << endl << "B's func called " << getB() << " times" << endl << "C's func called " << getC() << " times" << endl;
}


int main()
{
	D d;
	int new_val;
	cin >> new_val;
	d.check(new_val);

}