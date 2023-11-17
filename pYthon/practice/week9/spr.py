import math


def sparseForm(vect):

    size = len(vect)

    dict = {}

    for i in range(size):
        if (vect[i] != 0):
            dict[i] = vect[i]

    return size, dict


def revert(spr):

    size = spr[0]
    dict = spr[1]
    rev_vect = [0] * size

    for key in dict:
        rev_vect[key] = dict[key]

    return rev_vect


def dot(spr1, spr2):
    sum = 0
    rev1 = revert(spr1)
    rev2 = revert(spr2)
    for i in range(len(rev1)):
        sum += (rev1[i] * rev2[i])
    return sum


def getCosinSim(spr1, spr2):

    dot_prod = dot(spr1, spr2)

    return dot_prod / (magnitude(spr1) * magnitude(spr2))


def magnitude(spr):
    vect = revert(spr)
    sum = 0
    for i in vect:
        sum += i**2

    return math.sqrt(sum)


# t =  [0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 5, 0, 0, 0, 9, 0]
# spr1 = (34, {5:1, 11:9, 14:8, 17:6, 20:7, 21:5, 22:1, 25:2, 26:8, 32:5, 33:1})
# spr2 = (34, {1:2, 3:3, 5:4, 11:8, 15:1, 18:1, 22:1, 25:1, 29:1, 30:1, 31:1, 33:1})
# # print(revert(spr1))
# # print(dot(spr1, spr2))
# # print(sparseForm(t))
# # print(revert(sparseForm(t)))
# print(magnitude(spr1))
# print(getCosinSim(spr1, spr2))

