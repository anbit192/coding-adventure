import math


class Polynomial:
    def __init__(self, coefficients):
        self.coefficients = coefficients
        self.degree = len(coefficients) - 1

    def get_degree(self) -> int:
        return self.degree

    def add(self, another):
        new_coeffs = []
        max_degree = max(self.get_degree(), another.get_degree())
        print(max_degree)

        if (self.get_degree() == max_degree):
            for i in range(another.degree + 1):
                new_coeffs.append(
                    self.coefficients[i] + another.coefficients[i])
            for i in range(another.degree + 1, max_degree + 1):
                new_coeffs.append(
                    self.coefficients[i])

        else:
            for i in range(self.degree + 1):
                new_coeffs.append(
                    self.coefficients[i] + another.coefficients[i])
            for i in range(self.degree + 1, max_degree + 1):
                new_coeffs.append(
                    another.coefficients[i])
        return Polynomial(new_coeffs)
    
    def minus(self, another):
        new_coeffs = []
        max_degree = max(self.get_degree(), another.get_degree())

        if (self.degree == max_degree):
            for i in range(another.degree + 1):
                new_coeffs[i] = self.coefficients[i] - another.coefficients[i]
            for i in range(another.degree + 1, max_degree + 1):
                new_coeffs[i] = self.coefficients[i]
        else:
            for i in range(self.degree + 1):
                new_coeffs[i] = self.coefficients[i] - another.coefficients[i]
            for i in range(self.degree + 1, max_degree + 1):
                new_coeffs[i] = 0 - another.coefficients[i]
        
        return Polynomial(new_coeffs)


    def print_poly(self):
        string = ""
        for i in range(self.degree + 1):
            string += (f"{self.coefficients[i]}x^{i} + ")

        return string[:-2]
    

def main():
    poly1 = Polynomial([1, 2, 3])
    poly2 = Polynomial([1, 1, 1, 1, 1])

    print(poly1.add(poly2).print_poly())
    print(poly1.minus(poly2).print_poly())


main()
