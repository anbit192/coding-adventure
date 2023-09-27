import math


def mean(s):
    sum = 0
    for i in s:
        sum += i
    return sum / len(s)


def variance(s):
    e = mean(s)
    var = 0
    for i in range(len(s)):
        var += ((s[i] - e) ** 2)
    return var / len(s)


def standarddeviation(s):
    return math.sqrt(variance(s))


print(math.sqrt(17.5 / 6))
