import math


def cosineb2v(u, v):
    return scala(u,v)/(len_vector(u)*len_vector(v))

def len_vector(u):
    sum_sqr=0
    for i in u:
        sum_sqr+=i**2

    return math.sqrt(sum_sqr)

def scala(u,v):
    dot = 0
    for i in range(len(u)):
        dot += u[i]*v[i]
    return dot
