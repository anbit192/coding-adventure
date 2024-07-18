// #include<bits/stdc++.h>
#include <iostream>

using namespace std;
//Implement the class Box  
//l,b,h are integers representing the dimensions of the box
class Box 
{
    private:int l,b,h;
    
    public:Box()
    {
        this->l = 0;
        this->b = 0;
        this->h = 0;
    }

    public:Box(int l, int b,int h)
    {
        this->l = l;
        this->b = b;
        this->h = h;
    }
    
    public:int getLength()
    {
        return this->l;
    }
    
    public:int getBreadth()
    {
        return this->b;
    }
    
    public:int getHeight()
    {
        return this->h;
    }

    public:long CalculateVolume()
    {
        return this->l * this->b * this->h;
    }

    bool operator < (Box& box) 
    {
        if (this->l < box.l)
        {
            return true;
        } 

        else if (this->b < box.b && this->l == box.l )
        {
            return true;
        }

        else if (this->h < box.h && this->l == box.l && this->b == box.b)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // friend void operator << (ostream& os, const Box& box);
};

ostream& operator << (ostream& os, Box& box)
{
    return os << box.getLength() << " " << box.getBreadth() << " " << box.getHeight();  
};

// The class should have the following functions : 

// Constructors: 
// Box();
// Box(int,int,int);
// Box(Box);


// int getLength(); // Return box's length
// int getBreadth (); // Return box's breadth
// int getHeight ();  //Return box's height
// long long CalculateVolume(); // Return the volume of the box

//Overload operator < as specified
//bool operator<(Box& b)

//Overload operator << as specified
//ostream& operator<<(ostream& out, Box& B)

int main()
{
    return 0;
}