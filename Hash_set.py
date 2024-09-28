class Node:
    def __init__(self, value, nextNode=None):
        self.value = value
        self.next = nextNode
        
class Bucket:
    def __init__(self):
        self.head = Node(0)

    def insert(self, newValue):
        if not self.exists(newValue):
            newNode = Node(newValue, self.head.next)
            self.head.next = newNode

    def delete(self, value):
        prev = self.head
        curr = self.head.next
        while curr is not None:
            if curr.value == value:
                prev.next = curr.next
                return
            prev = curr
            curr = curr.next

    def exists(self, value):
        curr = self.head.next
        while curr is not None:
            if curr.value == value:
                return True
            curr = curr.next
        return False
    
class MyHashSet:

    def __init__(self):
        self.key_range=1000
        self.bucketArray = [Bucket() for i in range(self.key_range)]
    
    def hash(self,key):
        return key%self.key_range
        

    def add(self, key: int) -> None:
        bucketIndex=self.hash(key)
        self.bucketArray[bucketIndex].insert(key)
        
    def remove(self, key: int) -> None:
        bucketIndex=self.hash(key)
        self.bucketArray[bucketIndex].delete(key)

    def contains(self, key: int) -> bool:
        bucketIndex=self.hash(key)
        return self.bucketArray[bucketIndex].exists(key)