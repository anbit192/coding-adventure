def sort_key(dict):
    list_keys = list(dict.keys())
    n = len(list_keys)
    for i in range(n):
        for j in range(n):
            if (dict.get(list_keys[j]) > dict.get(list_keys[j - 1])):
                temp = list_keys[j]
                list_keys[j] = list_keys[j - 1]
                list_keys[j - 1] = temp
    return list_keys


def main():
    input_str = input().strip()

    char_seq = {}
    for i in input_str:
        char_seq[i] = char_seq.get(i, 0) + 1

    list_keys = sorted(char_seq.items(), key=lambda x: x[1], reverse=True)

    print(f"{list_keys[0][0]} {list_keys[0][1]}")


main()
