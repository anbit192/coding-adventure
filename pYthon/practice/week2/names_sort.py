import locale

locale.setlocale(locale.LC_ALL, 'vi_VN')


def inputList():
    names = []

    while (True):
        user_input = input()
        if (user_input == ""):
            break
        else:
            names.append(user_input)

    return names


def getName(s):
    lname = ''
    fname = ''

    list_str = s.split()

    for i in range(len(list_str) - 1):
        lname += (list_str[i] + " ")

    fname += list_str[-1]

    return (lname, fname)


def sortNamesList(names):
    return sorted(names, key=lambda name: (locale.strxfrm(getName(name)[1]), locale.strxfrm(getName(name)[0])))



names = inputList()
print(sortNamesList(names))