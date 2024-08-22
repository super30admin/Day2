# Time Complexity : find, put, get, remove => o(n), getbucket =>o(1) 
# Space Complexity : o(n)
# Did this code successfully run on Leetcode : Yes

class Node:
    def __init__(self, key: int, value: int) -> None:
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:
    
    def __init__(self):
        self.buckets = 10000                            
        self.storage = [None]*self.buckets              # primary array of size 10000
        
    def getBucket(self, key: int) -> int:
        return key%self.buckets                         # hash function to get index
        
    def find(self, head: Node, key: int):
        prev = head                                     # returns prev pointer of the node that is to be found in linked list 
        curr = head.next
        while curr and curr.key!=key:
            prev =curr
            curr = curr.next
        return prev    
            
    def put(self, key: int, value: int) -> None:        # Dummy node is created to handle the removal of first node 
        index = self.getBucket(key)
        if self.storage[index] == None:
            self.storage[index] = Node(-1,-1)
        prev = self.find(self.storage[index],key)
        if prev.next == None:                           # if the returned pointer is at the last position, it is assumed that new key to be added is unique
            prev.next = Node(key,value)
        else:
            prev.next.value = value                     # else the key is updated with new value
                
    def get(self, key: int) -> int:                     
        index = self.getBucket(key)
        if self.storage[index] == None:                 # if the index is not initialized, it's obvious that the key has not been added
            return -1
        prev = self.find(self.storage[index],key)       
        if prev.next == None:                           # if last position is reached, it's assumed that the key is not present
            return -1
        return prev.next.value                  

    def remove(self, key: int) -> None:
        index = self.getBucket(key)
        if self.storage[index] == None:                 # if index not initialized, no key was added
            return
        prev = self.find(self.storage[index],key)
        if prev.next == None:                           # last position reached, so the key is not present
            return
        prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)