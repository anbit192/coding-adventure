def main():

    n = int(input())
    temp = 0
    sum = 0

    for i in range(4):
        temp = (temp * 10**len(str(n)) + n)
        sum += temp


    print(sum)





main()