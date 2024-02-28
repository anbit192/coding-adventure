import random


def main():

    array = generate_randoms()
    # array = [6, 9, -1, 2, -8, -5, 7, 0, -3, 8]
    print("Original array: ", array)
    print("============================")

    selection_sort(array)

    print("============================")
    print("sorted array: ", array)


def generate_randoms(size=10):
    array = []

    for _ in range(size):
        array.append(random.randint(-size, size))

    return array


def selection_sort(array: list):
    current_idx = 0
    while (current_idx < len(array) - 1):
        min_idx = find_min_index(array=array, start_idx=current_idx)

        temp = array[current_idx]
        array[current_idx] = array[min_idx]
        array[min_idx] = temp

        current_idx += 1


def find_min_index(array: list, start_idx=0):

    min_idx = start_idx
    for i in range(start_idx + 1, len(array)):
        if (array[i] < array[min_idx]):
            min_idx = i
    print(f"Current min: {array[min_idx]}")
    
    return min_idx
main()
