import random


def main():

    array = generate_randoms()
    print("Original array: ", array)
    print("============================")

    stalin_sort(array)

    print("============================")
    print("StalinED array: ", array)


def generate_randoms(size=10):
    array = []

    for _ in range(size):
        array.append(random.randint(-size, size))

    return array


def stalin_sort(array: list):

    i = 0
    while (i < len(array) - 1):
        print(f"Comparing {array[i]} and {array[i + 1]}")

        if (array[i] > array[i + 1]):
            temp = array.pop(i + 1)
            print(f"Removed : {temp}, current array: {array}")

            i -= 1

        i += 1


main()
