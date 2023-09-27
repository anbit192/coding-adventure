import math


def area(a, b, c):
    s = (a + b + c) / 2
    return math.sqrt(s * (s - a) * (s - b) * (s - c))


def is_triangle(a, b, c):
    if (a + b > c and b + c > a and a + c > b):
        return True

    else:
        return False



def main():
    a = float(input())
    b = float(input())
    c = float(input())

    if (is_triangle(a, b, c) == True):
        s = area(a, b, c)
        c = a + b + c

        print(f"S =  {s} C =  {c}")

    else:
        print("INVALID")

main()
