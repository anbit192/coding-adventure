import math


class Polynomial:
    def __init__(self, coefficients):
        self.coefficients = coefficients
        self.degree = len(coefficients) - 1

    def get_degree(self) -> int:
        return self.degree

    def add(self, another: "Polynomial") -> "Polynomial":
        new_coeffs = []
        max_degree = max(self.get_degree(), another.get_degree())

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

    def minus(self, another: "Polynomial") -> "Polynomial":
        new_coeffs = []
        max_degree = max(self.get_degree(), another.get_degree())

        if (self.degree >= max_degree):
            for i in range(another.degree + 1):
                new_coeffs.append(self.coefficients[i] - another.coefficients[i])
            for i in range(another.degree + 1, max_degree + 1):
                new_coeffs.append(self.coefficients[i])
        else:
            for i in range(self.degree + 1):
                new_coeffs.append(self.coefficients[i] - another.coefficients[i])
            for i in range(self.degree + 1, max_degree + 1):
                new_coeffs.append(0 - another.coefficients[i])

        return Polynomial(new_coeffs)

    def multi(self, another: "Polynomial") -> "Polynomial":
        max_degree = self.degree + another.degree

        new_coeffs = [0 for i in range(max_degree + 1)]  # degree 3 => len = 3 + 1; degree 2 => len = 2 + 1 ||
        # => degree 3 * 2 = 6 => len(6 + 1)
        for i in range(self.degree + 1):
            for j in range(another.degree + 1):
                new_coeffs[i + j] += self.coefficients[i] * another.coefficients[j]

        return Polynomial(new_coeffs)

    def print_poly(self):
        string = ""
        for i in range(self.degree + 1):
            current_coeff: int = self.coefficients[i]
            if (current_coeff == 0):
                continue
            if (i == 0):
                string += f"{current_coeff} + "
            elif (current_coeff == 1 and i != 0):
                string += (f"x^{i} + ")
            elif (current_coeff < 0):
                temp: str = string[:-2]
                temp += "- "
                if (current_coeff == -1 and i != 0):
                    temp += f"x^{i} + "
                else:
                    temp += f"{abs(current_coeff)}x^{i} + "
                string = temp

            else:
                string += (f"{current_coeff}x^{i} + ")

        print(string[:-2])


def main():
    poly1 = Polynomial([1, 2, 1])
    poly2 = Polynomial([1, 1])

    poly1.print_poly()
    poly2.print_poly()

    poly1.add(poly2).print_poly()
    poly2.minus(poly1).print_poly()
    poly2.multi(poly1).print_poly()


main()
