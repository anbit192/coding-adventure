def findLuckyNumber(filename):

    file = open(filename, "r")
    items = read_file(file)

    luckies = []

    for line in items:
        for i in line:
            if (i.isdigit() and is_lucky_number(i) and is_prime(int(i))):
                luckies.append(i)

    return luckies


def is_lucky_number(str):
    sum = 0
    for i in str:
        sum += int(i)
    return (sum % 5 == 0)


def is_prime(num):
    if (num < 1):
        return False
    for i in range(2, num):
        if (num % i == 0):
            return False
    return True


def read_file(file):
    items = []

    for line in file:
        l = []
        for i in line.split():
            l.append(i)
        items.append(l)
    return items


def main():
    findLuckyNumber("txt_list/luckies.txt")


main()
