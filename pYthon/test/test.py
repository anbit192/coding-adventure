s = "A B C D"
def get_pair(s):
    temp = []

    tmp_list = s.split()
    for i in range(len(tmp_list) - 1):
        tmp_str = f"{tmp_list[i]} {tmp_list[i+1]}"
        temp.append(tmp_str)
    return temp

print(get_pair(s))