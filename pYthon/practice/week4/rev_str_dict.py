def create_dict(list):
    dict = {}

    for i in range(len(list)):
        dict[list[i]] = list[i] + reverse_string(list[i])

    return dict

def reverse_string(str):

    list_temp = list(str)
    new_str = ""
    size = len(list_temp)
    for i in range(size):
         new_str += list_temp[size - i - 1]
    return new_str


def input_strings():

    list_str = input().split()


    return list_str

def main():

    print(create_dict(input_strings()))

main()