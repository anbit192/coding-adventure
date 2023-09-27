import math


def print_pascal_triangle(m):
    for i in range(m + 1):
        for j in range(i + 1):
            item = math.factorial(i) // (math.factorial(j) * math.factorial(i - j))
            print(f"{item}", end=" ")

        print()


def main():
    print_pascal_triangle(int(input()))


main()
