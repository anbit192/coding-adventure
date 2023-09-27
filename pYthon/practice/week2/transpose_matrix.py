def inputMatrix():
    matrix = []
    while True:
        row_input = input()

        if row_input == '':
            break

        row = row_input.strip().split()
        matrix.append(row)

    return matrix


def transpose(matrix):
    t = []
    for i in range(len(matrix[0])):
        row = []
        for j in range(len(matrix)):
            row.append(matrix[j][i])
        t.append(row)
    return t


def printMatrix(t):
    for row in t:
        for element in row:
            print(element, end='\t')
        print()


m = inputMatrix()
t = transpose(m)
printMatrix(t)
