class MyHashMap:
    class Node(object):
        def __init__(self, key, value, next):
            self.key = key
            self.value = value
            self.next = None
            
    def __init__(self):
        self.arr = [None] * 10000
        
    def hash_func(self, val):
        return val % 10000
    def find(self, head, key):
        
        prev = None
        curr = head
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev
    
    def put(self, key: int, value: int) -> None:
        hash_val = self.hash_func(key)
        if self.arr[hash_val] == None:
            self.arr[hash_val] = self.Node(-1, -1, None)
        prev = self.find(self.arr[hash_val], key)
        if prev.next == None:
            prev.next = self.Node(key, value, None)
        else:
            prev.next.value = value
            
    def get(self, key: int) -> int:
        hash_value = self.hash_func(key)
        if self.arr[hash_value] == None:
            return -1
        else:
            prev = self.find(self.arr[hash_value], key)
            if prev.next != None:
                return prev.next.value
            else:
                return -1
            
    def remove(self, key: int) -> None:
        hash_value = self.hash_func(key)
        if self.arr[hash_value] == None: return
        prev = self.find(self.arr[hash_value], key)
        if prev.next == None: return
        prev.next = prev.next.next