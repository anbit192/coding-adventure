def inputMatrix():
    matrix = []
    while True:
        row_input = input()

        if row_input == '':
            break

        row = row_input.strip().split()
        matrix.append(row)
        print(row)

    return matrix


def isUpperTriangleMatrix(m):
    for i in range(1, len(m)):
        for j in range(0, i):
            if int(m[i][j]) != 0:
                return False
    return True


m = inputMatrix()
print(isUpperTriangleMatrix(m))
