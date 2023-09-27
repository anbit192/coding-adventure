import math
def pytago_check(a, b, c):
    return (c == math.sqrt(a**2 + b**2))

def find_pytago_in_range(n):
    if (n < 3):
        return None
    list_pytago = []
    for i in range(1, n - 1):
        for j in range(i + 1, n):
            for k in range(j + 1, n + 1):
                if (pytago_check(i, j ,k) == True):
                    list_temp = [i, j, k]
                    list_pytago.append(list_temp)

    for item in list_pytago:
        print(f"({item[0]}, {item[1]}, {item[2]})")




def main():
    n = int(input())
    find_pytago_in_range(n)

main()