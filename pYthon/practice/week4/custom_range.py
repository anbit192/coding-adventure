def find_numbers(a, b):
    list_num = []
    for i in range(a, b + 1):
        if (i % 11 == 0 and i % 3 != 0):
            list_num.append(i)

    return list_num


def print_list(list_numbers):
    str = ""
    for i in list_numbers:
        str += f"{i} "

    new_str = str.replace(" ", "; ")

    print(new_str[:-2])


def main():
    a = int(input())
    b = int(input())

    list_numbers = find_numbers(a, b)

    print_list(list_numbers)


main()
