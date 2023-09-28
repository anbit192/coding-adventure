def create_dict(n):
    dict = {}

    for i in range(1, n + 1):
        dict[i] = reverse_string(str(i**2))

    return dict

def reverse_string(str):

    list_temp = list(str)
    new_str = ""
    size = len(list_temp)
    for i in range(size):
         new_str += list_temp[size - i - 1]
    return new_str


def main():
    n = int(input())
    print(create_dict(n))

main()