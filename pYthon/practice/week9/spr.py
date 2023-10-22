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

    for key in dict.keys():
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

    rev1 = revert(spr1)
    rev2 = revert(spr2)
    dot_prod = dot(rev1, rev2)

    return dot_prod / (magnitude(rev1) * magnitude(rev2))


def magnitude(vect):
    sum = 0
    for i in vect:
        sum += i**2

    return math.sqrt(sum)
