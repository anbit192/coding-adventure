import math


class Point():

    def __init__(self, x, y):
        self.x = x
        self.y = y

    def distance(self, other) -> float:
        dist = (self.x - other.x)**2 + (self.y + other.y)**2

        return math.sqrt(dist)


def main():
    p1 = Point(1, 1)
    p2 = Point(0, 0)

    print(p1.distance(p2))


main()
