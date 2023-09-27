import math
def solver(a, b ,c):
    if (a == 0):
        if (b == 0):
            if (c == 0):
                print("VSN")

            else:
                print(c)
        
        else:
            print(-c/b)

    else:
        if (b == 0):
            if (c > 0):
                print( "VN")

            else:
                print(c/a , " " ,-c/a)

        elif (b == 0 and c == 0):
            print("VSN")
        else:
            delta = b**2 - 4*a*c
            
            if (delta > 0):
                x1 = (-b + math.sqrt(delta))/2*a
                x2 = (-b - math.sqrt(delta))/2*a
                print(x2, " " , x1)


            elif (delta == 0):
                x1 = (-b + math.sqrt(delta))/2*a
                print(x1)

            else:
                print("VN")


            

list_input = input().split(" ")


a = float(list_input[0])
b = float(list_input[1])
c = float(list_input[2])



solver(a,b,c)