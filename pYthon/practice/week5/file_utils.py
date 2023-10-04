import os


def search_file(str, path):
    file_list = os.listdir(path)
    list_res = []

    new_path = path
    for file_dir in file_list:
        new_path += file_dir
        file = open(new_path, "r")
        temp = []

        line_list = file.readlines()
        count = 1
        for line in line_list:
            if (str in line):
                temp.append(new_path)
                temp.append(line)

                list_res.append(tuple(temp))
                new_path = path
                break
            else:
                count = count + 1

    sort_by_name(list_res)

    return list_res


def sort_by_name(results):
    for i in range(len(results)):
        for j in range(len(results) - 1):
            if (results[j][0] > results[j + 1][0]):
                temp = results[j]
                results[j] = results[j + 1]
                results[j + 1] = temp

    

def main():
    res = search_file("buoi", "txt_list/")
    print(res)


main()
