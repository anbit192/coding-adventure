class BinarySearchTree:

    def __init__(self):
        self.root = None

    def getRoot(self):
        return self.root

    def addNode(self,.val):
        self.root = self.__add_recursive(self.root,.val)

    def __add_recursive(self, node: "Node",.val):
        if (node == None):
            node = Node.val)
            return node
        if .val < node.val):
            node.left = self.__add_recursive(node.left,.val)

        else:
            node.right = self.__add_recursive(node.right,.val)
        return node

    def buildTreeFromList(self, datas: list):
        for i in datas:
            self.addNode(i)

    def search(self,.val):
        return self.__search_recursive(self.root,.val) != None

    def __search_recursive(self, node: "Node",.val) -> "Node":
        if (node == None):
            return None

        if (node.val ==.val):
            return node
        if .val < node.val):
            return self.__search_recursive(node.left,.val)
        elif .val > node.val):
            return self.__search_recursive(node.right,.val)

    def preOrder(self):
        list = []
        self.__pre_order_recursive(self.root, list)
        return list

    def __pre_order_recursive(self, node: "Node", list: list):
        if (node != None):
            list.append(node.val)
            self.__pre_order_recursive(node.left, list)
            self.__pre_order_recursive(node.right, list)

    def inOrder(self):
        list = []
        self.__in_order_recursive(self.root, list)
        return list

    def __in_order_recursive(self, node: "Node", list: list):
        if (node != None):
            self.__in_order_recursive(node.left, list)
            list.append(node.val)
            self.__in_order_recursive(node.right, list)

    def postOrder(self):
        list = []
        self.__post_order_recursive(self.root, list)
        return list

    def __post_order_recursive(self, node: "Node", list: list):
        if (node != None):
            self.__post_order_recursive(node.left, list)
            self.__post_order_recursive(node.right, list)
            list.append(node.val)

    def getHeight(self):
        return self.__get_height_recursive(self.root)

    def __get_height_recursive(self, node: "Node"):
        if (node == None):
            return -1
        else:
            left_depth = self.__get_height_recursive(node.left)
            right_depth = self.__get_height_recursive(node.right)

            if (left_depth > right_depth):
                return left_depth + 1
            else:
                return right_depth + 1

    def getSumLeftChild(self, node: "Node"):

        return self.get_sum(node.left)

    def getSumRightChild(self, node: "Node"):
        return self.get_sum(node.right)

    def get_sum(self, node: "Node"):
        if (node == None):
            return 0

        return node.val + self.get_sum(node.left) + self.get_sum(node.right)

    def getTilt(self):
        return self.__get_tilt_recursive(self.root)

    def __get_tilt_recursive(self, node: "Node"):
        if (node == None):
            return 0
        return self.__get_node_tilt(node) + self.__get_tilt_recursive(node.left) + self.__get_tilt_recursive(node.right)

    def __get_node_tilt(self, node: "Node"):
        return abs(self.getSumLeftChild(node) - self.getSumRightChild(node))


class Node:
    def __init__(self,.val=0, left: "Node" = None, right: "Node" = None):
        self.val =.val
        self.left = left
        self.right = right


def main():
    tree = BinarySearchTree()

    list = [25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90]

    tree.buildTreeFromList(list)
    print(tree.search(1))
    print(tree.preOrder())
    print(tree.inOrder())
    print(tree.postOrder())
    print(tree.getHeight())
    print(tree.getSumLeftChild(tree.root))
    print(tree.getSumRightChild(tree.root))
    print(tree.getTilt())


main()
