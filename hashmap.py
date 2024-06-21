"""
Time Complexity: O(n)
Space Complexity: O(n)
"""

class Node:
    def __init__(self, key, value ):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:
    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * self.buckets 

    def hash(self, key):
        return key%self.buckets

    def find(self, head, key):
        prev = None
        curr = head
        while curr is not None and curr.key != key:
            prev = curr 
            curr = curr.next
        return prev 

    def put(self, key: int, value: int) -> None:
        index = self.hash(key)
        new_node = Node(key, value)

        if self.storage[index] is None:
            self.storage[index] = Node(-1,-1)
        prev = self.find(self.storage[index], key)

        if prev.next is None:
            prev.next = new_node
        else:
            prev.next.value = new_node.value

    def get(self, key: int) -> int:
        index = self.hash(key)
        if self.storage[index] is None:
            return -1

        prev = self.find(self.storage[index], key)
        if prev.next is  None:
                return -1
        return prev.next.value

    def remove(self, key: int) -> None:
        index = self.hash(key)
        if self.storage[index] is not None:
            prev = self.find(self.storage[index], key)
            if prev.next is not None:
                temp = prev.next
                prev.next = temp.next
                temp.next = None

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)