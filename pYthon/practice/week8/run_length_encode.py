def length(array):
    if (len(array) == 0):
        return 0
    return len(compress(array))


def compress(array):
    compressed_array = []

    count = 1
    for i in range(len(array) - 1):

        if (array[i] != array[i + 1]):
            compressed_array.append(array[i])
            compressed_array.append(count)
            count = 1
        else:
            count += 1

    # append the last item of array, count, to compressed_array
    compressed_array.append(array[-1])
    compressed_array.append(count)
    return compressed_array


def lengthInverse(compressed_array):
    return len(decompress(compressed_array))


def decompress(compressed_array):
    decompressed_array = []

    for i in range(0, len(compressed_array), 2):
        count = compressed_array[i + 1]
        for j in range(count):
            decompressed_array.append(compressed_array[i])

    return decompressed_array

# def main():
#     arr = [0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0]
#     print(compress(arr))
#     print(decompress(compress(arr)))
#
# main()
