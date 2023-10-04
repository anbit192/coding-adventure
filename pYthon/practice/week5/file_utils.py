import os


def search_file(str, path):
    file_list = os.listdir(path)
    list_res = []

    new_path = path
    for file_dir in file_list:
        new_path += "\\" + file_dir
        file = open(new_path, "r")
        temp = []

        line_list = file.readlines()
        count = 1
        for line in line_list:
            if (str in line):
                temp.append(file_dir)
                temp.append(line)

                list_res.append(temp)
                new_path = path
                break
            else:
                count = count + 1

    return list_res


def main():
    res = search_file("buoi", "C:\\Users\\Admin\\Desktop\\study\\coding-adventure\\pYthon\\practice\\week5\\txt_list")
    print(res)

main()