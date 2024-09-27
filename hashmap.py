#Time Complexity -> O(1) for push,pop and search in avg cases, worst case O(n) in all three operations
#Space Complexty -> O(n) for creation of n nodes for n values.
class MyHashMap:

    def __init__(self):
        self.n = 10000
        self.hashmap = [LinkedList() for _ in range(self.n)]
        

    def put(self, key: int, value: int) -> None:
        self._get(key).add(key, value)
        

    def get(self, key: int) -> int:
        node = self._get(key).find(key)
        return node.value if node else -1
        

    def remove(self, key: int) -> None:
        self._get(key).remove(key)
        
    
    def _get(self, key):
        hashValue = key % self.n
        return self.hashmap[hashValue]
    
    def contains(self, key):
        return self._get(key).contains(key)
    
    
class LinkedList:
    def __init__(self):
        self.head = None
        
    def add(self, key, value):
        node = self.find(key)
        
        if node:
            node.value = value
            return
        
        node = Node(key, value)
        node.next = self.head
        self.head = node
        
    def remove(self, key):
        if self.head and self.head.key == key:
            self.head = self.head.next
            return
        
        prev = None
        cur = self.head
        
        while cur and cur.key != key:
            prev = cur
            cur = cur.next
            
        if cur:
            prev.next = cur.next
            
    def contains(self, key):
        return True if self.find(key) else False
    
    def find(self, key):
        cur = self.head
        
        while cur and cur.key != key:
            cur = cur.next
            
        return cur
    
class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None