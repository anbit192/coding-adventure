class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.head = Node()
        self.tail = Node()

        self.head.next = self.tail
        self.tail.prev = self.head

        self.mp = {}
        

    def add_node(self, node):
        temp = self.head.next
        self.head.next = node
        node.prev = self.head

        node.next = temp
        temp.prev = node

    def delete_node(self, node):
        prev_ = node.prev
        next_ = node.next

        prev_.next = next_
        next_.prev = prev_
        

    def get(self, key: int) -> int:
        res_node = self.mp.pop(key, -1)
        if (res_node == -1):
            return -1

        self.delete_node(res_node)
        self.add_node(res_node)
        self.mp[key] = self.head.next

        return self.mp[key].val
        

    def put(self, key: int, value: int):
        res_node = self.mp.get(key, -1)
        if (res_node != -1):
            res_node.val = value
            self.delete_node(res_node)
            self.mp.pop(key)

        if (len(self.mp) >= self.capacity):
            self.mp.pop(self.tail.prev.key)
            self.delete_node(self.tail.prev)

        new_node = Node(key, value)
        self.add_node(new_node)
        self.mp[key] = self.head.next

        
class Node:
    def __init__(self ,key=-1 ,val=-1, next=None, prev=None):
        self.key = key
        self.val = val
        self.next = next
        self.prev = prev