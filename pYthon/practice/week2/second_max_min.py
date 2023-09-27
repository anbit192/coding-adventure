def input_array():
    array = []

    while (True):
        user_input = input()

        if (user_input == ""):
            break
        for i in user_input.split():
            array.append(int(i))

        for i in range(len(array)):
            array[i] = int(array[i])

    return array




def find_second_max_min(array):

    array.sort()

    a = array[1]  # second_max
    b = array[-2]  # second_min


    return a, b


array = input_array()
print(find_second_max_min(array))