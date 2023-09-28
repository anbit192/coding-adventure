def query_line(str, total):
    query = str.split()

    if (query[0] == "D"):
        total += int(query[1])


    elif (query[0] == "W"):

        total -= int(query[1])

    return total


def user_input():
    list = []

    while (True):
        input_user = input().strip()
        if (input_user == ""):
            break
        list.append(input_user)

    return list


def main():
    user_inputs = user_input();

    total = 0

    for i in user_inputs:
        total = query_line(i, total)

    print(total)


main()
