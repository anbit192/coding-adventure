
def convert_dec(bin):
    return int(bin, 2)

def user_input():
    list_input = input().split(",")

    return list_input

def main():

    list_num = user_input()
    list_res = []
    for i in list_num:
        if (convert_dec(i) % 5 == 0):
            list_res.append(i)


    print(",".join(list_res))

main()