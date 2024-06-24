class Node:

    def __init__(self,key,val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.bucket = [None]*self.size
    
    def hash(self, key):
        return key % self.size

#Time Complexity O(1)
#Space Complexity O(n)
    def put(self, key: int, val: int) -> None:
        index = self.hash(key)
        if self.bucket[index] is None:
            self.bucket[index] = Node(key, val)
        else:
            curr = self.bucket[index]
            while curr:
                if curr.key == key:
                    curr.val = val
                    return
                if curr.next is None:
                    break
                curr=curr.next
            curr.next = Node(key,val)

#Time Complexity O(1)
#Space Complexity O(1)     
    def get(self, key: int) -> int:
        index = self.hash(key)
        curr = self.bucket[index]
        while curr:
            if curr.key == key:
                return curr.val
            curr = curr.next
        return -1
#Time Complexity O(1)
#Space Complexity O(1)

    def remove(self, key: int) -> None:
        index = self.hash(key)
        curr = self.bucket[index]
        prev = None
        while curr:
            if curr.key == key:
                if prev:
                    prev.next = curr.next
                else:
                    self.bucket[index] = curr.next
                return
            prev = curr
            curr = curr.next
        
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)