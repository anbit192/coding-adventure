def findCouple(filename):

    file = open(filename, "r")
    items = read_file(file)

    couples = []

    for i in range(len(items)):
        for j in range(len(items)):
            if (i == j):
                continue
            if (is_couple(items[i], items[j])):
                couples.append(items[i], items[j])

    return couples


def is_couple(a, b):
    if (a == b):
        return False
    return a == reverse_str(b)


def reverse_str(str):
    return str[::-1]


def read_file(file):
    items = []

    for line in file:
        for i in line.split():

            items.append(i)
    return items
