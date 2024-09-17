class Node:
    
    def __init__(self, val, next):
        self.val = val
        self.next = next

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 15
        self.h = [Node(None, None) for i in range(self.size)]

    def add(self, key: int) -> None:
        p = self.h[key % self.size]
        node = p.next
        while node:
            if node.val == key:
                break
            p = node
            node = node.next
        else:
            p.next = Node(key, None)

    def remove(self, key: int) -> None:
        p = self.h[key % self.size]
        node = p.next
        while node:
            if node.val == key:
                p.next = node.next
                break
            p = node
            node = node.next

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        node = self.h[key % self.size]
        while node:
            if node.val == key:
                return True
            node = node.next
        return False 


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
