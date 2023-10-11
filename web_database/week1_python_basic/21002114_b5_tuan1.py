def loop(n):
    factorial = 1
    for i in range(1, n + 1):
        factorial *= i
    
    return factorial

def recursive(n):
    if (n <= 0):
        return 1
    
    return recursive(n - 1) * n

print(recursive(6))
print(len(str(recursive(1000))))


    