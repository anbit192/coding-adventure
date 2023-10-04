#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'getTotalX' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY a
#  2. INTEGER_ARRAY b
#

def find_Divisor(a):
    divisor = []
    for i in range(1,a+1):
        if a % i == 0:
            divisor.append(i)
    return divisor
def common_divisor(a,b):
    common = []
    for i in a:
        if i in b:
            common.append(i)
    return common

def check_multiple_of_all(a,number):
    for i in a:
        if number%i != 0:
            return False
    return True

def getTotalX(a, b):
    # Write your code here
    #Find common_divisor of element in b\
    divisor_array = []
    for i in b:
        elements_divisor = find_Divisor(i)
        divisor_array.append(elements_divisor)
    common_divisor_of_b = divisor_array[0]
    for i in range(1,len(divisor_array)):
        common_divisor_of_b = common_divisor(common_divisor_of_b,divisor_array[i])

    result = 0

    for i in common_divisor_of_b:
        if check_multiple_of_all(a,i) == True:
            result += 1
    return result

# if _name_ == '_main_':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')
#
#     first_multiple_input = input().rstrip().split()
#
#     n = int(first_multiple_input[0])
#
#     m = int(first_multiple_input[1])
#
#     arr = list(map(int, input().rstrip().split()))
#
#     brr = list(map(int, input().rstrip().split()))
#
#     total = getTotalX(arr, brr)
#
#     fptr.write(str(total) + '\n')
#
#     fptr.close()
# r = check_multiple_of_all([1,2,3,4], 22)
# print(r)
a = getTotalX([2,4],[16,32,96])
print(a)
