def is_palindrome(p):
    p = str(p)
    n = len(p)
    for i in range(n//2):
        if (p[i] != p[n - i - 1]):
            return False
    return True

def main():
    p = int(input())
    print(is_palindrome(p))
main()