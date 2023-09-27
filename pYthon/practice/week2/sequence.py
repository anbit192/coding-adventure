def isAlt(a):
    if (len(a) < 2):
        return False

    for i in range(len(a) - 1):
        temp = a[i] * a[i + 1]
        if (temp >= 0):
            return False
    return True


def isGrow(a):
    if (len(a) < 2):
        return False

    for i in range(len(a) - 1):
        if (a[i] > a[i + 1]):
            return False

    return True


def isMulti(a):
    if (len(a) < 2):
        return False

    q = a[1] / a[0]

    for i in range(len(a) - 1):
        if (a[i + 1] / a[i] != q):
            return False

    return True


def isAdd(a):
    if (len(a) < 2):
        return False
    d = a[1] - a[0]

    for i in range(len(a) - 1):
        if (a[i + 1] - a[i] != d):
            return False

    return True


def main():
    list_input = input().split(" ")
    for i in range(len(list_input)):
        list_input[i] = int(list_input[i])

    print(isAlt(list_input))
    print(isGrow(list_input))
    print(isAdd(list_input))
    print(isMulti(list_input))


main()
