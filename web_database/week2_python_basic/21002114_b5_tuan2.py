class Rectangle:

    def __init__(self, w, h):
        self.width = w
        self.height = h

    def get_width(self):
        return self.width

    def get_height(self):
        return self.height

    def get_area(self):
        return self.height * self.width

    def get_perimeter(self):
        return (self.width + self.height) * 2

class Square(Rectangle):

    def __init__(self, side):
        super().__init__(side, side)


def main():
    w = int(input("width: "))
    h = int(input("height: "))

    rect = Rectangle(w,h)
    square = Square(w)

    print(rect.get_area())
    print(rect.get_perimeter())

    print(square.get_area())
    print(square.get_perimeter())

main()