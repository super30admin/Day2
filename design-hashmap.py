class Node:
    def __init__(self, key, value, next1=None):
        self.key = key
        self.value = value
        self.next = next1
        
class LinkedList:
    def __init__(self):
        self.sentinel = Node("key", "value")
    
    def get(self, key):
        curr = self.sentinel.next
        while curr:
            if curr.key == key:
                return curr.value
            curr = curr.next
        return -1
    
    def put(self, key, value):
        curr = self.sentinel.next
        prev = self.sentinel
        while curr:
            if curr.key == key:
                curr.value = value
                return
            prev = curr
            curr = curr.next
        prev.next = Node(key, value)
    
    def remove(self, key):
        curr = self.sentinel.next
        prev = self.sentinel
        while curr:
            if curr.key == key:
                prev.next = curr.next
                return
            prev = curr
            curr = curr.next
        return -1

class MyHashMap:
    # tc O(n/k), sc O(n + k),
    # where n is the number of all possible keys and k is the number of buckets in the hashmap, which is 2069.
    def __init__(self):
        self.hashvalue = 2069
        self.hasharray = [LinkedList() for _ in range(self.hashvalue)]
        

    def put(self, key: int, value: int) -> None:
        linkedlist = self.hasharray[key % self.hashvalue]
        return linkedlist.put(key, value)

    def get(self, key: int) -> int:
        linkedlist = self.hasharray[key % self.hashvalue]
        return linkedlist.get(key)

    def remove(self, key: int) -> None:
        linkedlist = self.hasharray[key % self.hashvalue]
        return linkedlist.remove(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)