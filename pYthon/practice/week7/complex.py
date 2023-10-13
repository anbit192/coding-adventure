class ComplexNumber:
    def __init__(self, real, image):
        self.real = real
        self.image = image

    def addComplex(self, another: "ComplexNumber") -> "ComplexNumber":
        return ComplexNumber(self.real + another.real, self.image + another.image)

    def subComplex(self, another: "ComplexNumber") -> "ComplexNumber":
        return ComplexNumber(self.real - another.real, self.image - another.image)


    def multiComplex(self, another: "ComplexNumber") -> "ComplexNumber":
        new_real = self.real * another.real - self.image * another.image
        new_image = self.real * another.image + self.image * another.real

        return ComplexNumber(new_real, new_image)

    def divComplex(self, another: "ComplexNumber") -> "ComplexNumber":
        new_real = float((self.real * another.real + self.image * another.image)) / (another.real**2 + another.image**2)
        new_image = float((self.image * another.real - self.real * another.image)) / (another.real**2 + another.image**2)

        return ComplexNumber(new_real, new_image)

    def toString(self):
        return f"{round(self.real,3)} + {round(self.image,3)}i"


def testDemo():
    a = ComplexNumber(2, 3)
    b = ComplexNumber(4, 5)

    print(a.addComplex(b).toString())
    print(a.subComplex(b).toString())
    print(a.multiComplex(b).toString())
    print(a.divComplex(b).toString())


'''
Bỏ comment lệnh testDemo() dưới đây để chạy test chương trình, và comment lại lệnh đó khi nộp bài
'''
testDemo()