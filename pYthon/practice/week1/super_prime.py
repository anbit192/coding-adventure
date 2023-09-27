def prime_check(number):

    if (number <= 1):
        return False
    elif (number == 2):
        return True

    for i in range(2, number):
        if (number % i == 0):
            return False

    return True


def check_super_prime(number):

    while (True):
        if (prime_check(number) == False):
            return False

        if (number // 10 == 0):
            break

        number//=10
    return True



def main():
    number = int(input())
    print(check_super_prime(number))

main()