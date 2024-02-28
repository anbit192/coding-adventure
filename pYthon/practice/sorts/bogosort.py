import random


def main():
    array = generate_randoms()
    print("Original array: ", array)
    print("============================")

    bogo_sort(array)

    print("============================")
    print("BogoED array: ", array)


def bogo_sort(array: list):
    # for _ in range(len(array)):
    count = 0
    while (True):
        print(f"Count: {count}")
        random_idx1 = 0
        random_idx1 = 0
        temp = array[0]
        while (True):
            random_idx1 = random.randint(0, len(array) - 1)
            random_idx2 = random.randint(0, len(array) - 1)

            if (random_idx1 != random_idx2):
                break

        temp = array[random_idx1]
        array[random_idx1] = array[random_idx2]
        array[random_idx2] = temp

        print("current array: ", array)

        if (check_sorted(array)):
            break

        count += 1


def check_sorted(array):
    for i in range(len(array) - 1):
        if (array[i] > array[i + 1]):
            return False
    return True


def generate_randoms(size=10):
    array = []

    for _ in range(size):
        array.append(random.randint(-size, size))

    return array


main()
