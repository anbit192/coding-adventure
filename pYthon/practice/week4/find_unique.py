def main():
    list_num = [1, 3, 2, 4, 4, 3, 1]
    print(findUniq(list_num))


def findUniq(list):
    # list_temp = []
    # i = 0
    # while (i < len(list)):
    #     if (list[i] not in list_temp):
    #         list_temp.append(list[i])
    #     else:
    #         list_temp.remove(list[i])
    #         list.pop(i)
    #         i = i - 1
    #     i = i + 1
    #
    # return list_temp[0]

    # XOR method
    res = 0
    for i in list:
        res = i ^ res

    return res


main()
