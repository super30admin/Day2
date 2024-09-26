# Time Complexity - O(n)
# Space Complexity - O(n) 
class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None
class MyHashMap:
    
    def __init__(self):
        self.size = 1000
        self.arr = [None] * (self.size + 1) 

    def hashFunc(self, key):
        return key % self.size
    
    def findPrev(self, index, key):
        prev = self.arr[index]
        curr = prev
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev
    
    def put(self, key: int, value: int) -> None:
        index = self.hashFunc(key)
        if self.arr[index] == None:
            self.arr[index] = Node(-1,-1)
        prev = self.findPrev(index, key)
        if prev.next is None:
            prev.next = Node(key, value)
        else :
            prev.next.val = value
            
    def get(self, key: int) -> int:
        index = self.hashFunc(key)
        if self.arr[index] == None:
            return -1
        prev = self.findPrev(index, key)
        if prev.next is None:
            return -1
        else :
            return prev.next.val

    def remove(self, key: int) -> None:
        index = self.hashFunc(key)
        if self.arr[index] == None:
            return -1
        prev = self.findPrev(index, key)
        if prev.next is None:
            return -1
        else :
            prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)