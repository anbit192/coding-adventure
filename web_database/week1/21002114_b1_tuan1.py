def sum_digits():

    count = 0
    for i in range(100, 1000):
        sum = 0

        str_num = [int(j) for j in str(i)]

        for j in str_num:
            sum += int(j)

        if (sum == 20):
            count += 1

    print(count)

sum_digits()
