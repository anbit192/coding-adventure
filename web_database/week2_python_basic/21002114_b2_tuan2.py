import math
def solver(a, b ,c):

    list_solutions = []

    if (a == 0):
        if (b == 0):
            if (c == 0):
                return None

            else:
                list_solutions.append(c)
        
        else:
            list_solutions.append(-c/b)

    else:
        if (b == 0):
            if (c > 0):
                return list_solutions

            else:
                list_solutions.append(c/a)
                list_solutions.append(-c/a)

        elif (b == 0 and c == 0):
            return None
        else:
            delta = b**2 - 4*a*c
            
            if (delta > 0):
                x1 = (-b + math.sqrt(delta))/2*a
                x2 = (-b - math.sqrt(delta))/2*a
                
                list_solutions.append(x2)
                list_solutions.append(x1)


            elif (delta == 0):
                x1 = (-b + math.sqrt(delta))/2*a
                list_solutions.append(x1)

            else:
                return list_solutions

    return sorted(list_solutions)

print(solver(-1, -2 ,1))
