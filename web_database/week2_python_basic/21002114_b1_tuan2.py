def checkPassword(str):
    if (len(str) < 8 or len(str) > 100):
        return False
    set_bool = set({})

    set_bool.add(has_uppercase(str))
    set_bool.add(has_lowercase(str))
    set_bool.add(has_digit(str))
    set_bool.add(has_special(str))

    return (len(set_bool) == 1)


def has_uppercase(str):
    for i in str:
        if (i.isupper()):

            return True
    return False

def has_lowercase(str):
    for i in str:
        if (i.islower()):


            return True
    return False

def has_digit(str):
    for i in str:
        if (i.isdigit()):

            return True

    return False

def has_special(str):

    for i in str:
        for j in "~!@#$%^&*" :
            if (j == i):
                return True

    return False


def main():

    while (True):
        input_pwd = input()
        if (checkPassword(input_pwd) == True):
            print("valid")
            break
        print("invalid!")

main()