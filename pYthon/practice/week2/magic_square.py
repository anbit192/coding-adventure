def isMagicSquare(matrix):

    sum_cols_sets = set(sum_cols(matrix))
    sum_rows_sets = set(sum_rows(matrix))

    sum_main_diag = sum_main_diagonal(matrix)
    sum_second_diag = sum_secondary_diagonal(matrix)

    sums_set = {sum_main_diag, sum_second_diag}

    for item in sum_rows_sets:
        sums_set.add(item)
    for item in sum_cols_sets:
        sums_set.add(item)

    return len(sums_set) == 1


def inputMatrix():
    matrix = []

    while (True):
        user_input = input()
        if (user_input == ""):
            break
        else:
            matrix.append(user_input.strip().split())

    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            matrix[i][j] = int(matrix[i][j])

    return matrix


def sum_secondary_diagonal(matrix):
    sum = 0

    for i in range(len(matrix)):
        sum += (matrix[i][len(matrix) - i - 1])
    return sum


def sum_main_diagonal(matrix):
    sum = 0

    for i in range(len(matrix)):
        sum += matrix[i][i]

    return sum


def sum_rows(matrix):
    list_sum = []

    for row in matrix:
        sum = 0
        for item in row:
            sum += item

        list_sum.append(sum)

    return list_sum


def sum_cols(matrix):
    list_sum = []

    for i in range(len(matrix[0])):
        sum = 0
        for j in range(len(matrix)):
            sum += matrix[j][i]
        list_sum.append(sum)

    return list_sum


def main():
    matrix = inputMatrix()



main()
