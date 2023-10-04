def zeroMove(fileName):

    file = open(fileName, "r")
    items = read_file(file)
    new_items = []

    count = 0
    for i in items:
        if (i != 0):
            new_items.append(i)
        else:
            count += 1

    for i in range(count):
        new_items.append(0)

    return new_items


def read_file(file):
    items = []

    for i in file:
        items += i.split()

    items = [int(i) for i in items]

    return items


def main():
    zeroMove("txt_list/zeros.txt")


main()
