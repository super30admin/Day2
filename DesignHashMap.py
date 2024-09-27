
#706. Design HashMap


class Empty:
    pass  

class Node:
    def Node(self, key: int, value: int, next:None):
        self.key = key
        self.value = value
        self.next = next
        

class MyHashMap:

    def __init__(self):
        self.empty = Empty()
        self.size = 10000
        self.bucket = [self.empty] * self.size
        
        
    def getBucket(self, key:int)-> int:
        return key % (self.size)
        
    def find(node,  key: int)->int:
        prev = node
        current = node.next
        while (current != None and current != key):
            prev= prev.next
            current= current.next
        return prev
        
        
            
        

    def put(self, key: int, value: int) -> None:
        bucket_key = self.getBucket(key)
        if self.bucket[bucket_key] == None:
            self.bucket[bucket_key]== Node(-1,-1)
        previousnode =  self.find(self.bucket[bucket_key], key)
        if previousnode == None:
            previousnode.next = Node(key,value)
        else:
             previousnode.next.value = value
        
        

    def get(self, key: int) -> int:
        bucket_key = self.getBucket(key)
        if self.bucket[bucket_key] == None:
            return -1
        else: 
            previousnode =  self.find(self.bucket[bucket_key], key)
            if previousnode != None:
                return previousnode.next.value
            else:
                return -1
        

    def remove(self, key: int) -> None:
        bucket_key = self.getBucket(key)
        if self.bucket[bucket_key] == None:
            return -1
        else:
            previousnode =  self.find(self.bucket[bucket_key], key)
            if previousnode != None:
                return previousnode.next == previousnode.next.next
            else:
                return 
            
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)