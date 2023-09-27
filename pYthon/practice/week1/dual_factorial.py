
def dual_factorial(number):
    factorial = 1
    if (number % 2 != 0):
        for i in range (1, number + 1 , 2):
            factorial*=i
    else:
        for i in range(2, number + 1, 2):
            factorial*=i

    return factorial

def main():
    n = int(input())
    print(f"{n}!! = {dual_factorial(n)} ")


main()