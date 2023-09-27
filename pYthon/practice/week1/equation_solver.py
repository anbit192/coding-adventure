import math


def f(x):
    return 5*x + 7

def solver(f, a, b, e = 0.000001):
    c = (a+b)/2

    if (abs(f(c)) <= e):
        return c
    if (f(a) * f(c) < 0):
        return solver(f, a, c, e = 0.000001)
    elif (f(c) * f(b) < 0):
        return solver(f, c, b, e = 0.000001 )

def main():
    print(solver(f, -4, 4))

main()