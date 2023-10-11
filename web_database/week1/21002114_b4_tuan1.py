def convert(i):
    prefix_int = ""
    if (len(str(i)) < 3):
        for j in range(3 - len(str(i))):
            print(prefix_int)
            prefix_int += "0"
    new_num = prefix_int + str(i)
    return new_num

print(convert(13))