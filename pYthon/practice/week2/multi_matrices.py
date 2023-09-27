

def multi(m1, m2):

    r = []

    for i in range(len(m1)):
        list_ = []
        for j in range(len(m2[0])):
            list_.append(int(0))
        r.append(list_)

    for i in range(len(m1)):
        for j in range(len(m2[0])):
            for k in range(len(m1[0])):
                r[i][j] += m1[i][k] * m2[k][j]

    return r


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



def main():
    m1 = inputMatrix()
    print("  asd  ")
    m2 = inputMatrix()

    print(multi(m1, m2))

main()