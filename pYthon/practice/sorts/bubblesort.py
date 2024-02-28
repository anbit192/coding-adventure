import random


def main():

    array = generate_randoms()
    print("Original array: ", array)
    print("============================")

    bubble_sort(array)

    print("============================")
    print("bubblED array: ", array)


def generate_randoms(size=10):
    array = []

    for _ in range(size):
        array.append(random.randint(-size, size))

    return array


def bubble_sort(array: list):
    for i in range(1, len(array)):
        for j in range(1, len(array)):
            if (array[j] < array[j - 1]):
                temp = array[j - 1]
                array[j - 1] = array[j]
                array[j] = temp


main()
