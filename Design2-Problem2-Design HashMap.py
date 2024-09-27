"""
Problem 2
706. Design HashMap

Time Complexity : 
    Operation:  
        Put( ) : O(1)
        find()   : O(1)
        get() : O(1)
        remove()  : O(1)

Space Complexity : O(N) 

Did this code successfully run on Leetcode : Yes

To achieve O(1) We hace selected the size of the primary array as 10000 and Nested Linked List to be upto 100

With the hash function we try to find the primary arry space.
if its empty a new LL node is created with a dummy value for simplicity

With the find fn, its the key is not present, the key and value is added to the LL

Similarly, to get a value we use the find function to fing the Value or it returns -1
 
To remove a key,value, if its present in the LL, with the find function returning prev node,
the prev.next is replaced with prev.next.next
    

@name: Rahul Govindkumar_RN27JUL2022
"""



class Node:
    
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.size = 10000
        self.storage =[None]*self.size
   
    def hash_fn(self, key):
        
        return key % self.size

    def put(self, key: int, value: int) -> None:
        idx = self.hash_fn(key)
        
        if(self.storage[idx] == None):
            self.storage[idx] = Node(-1,-1)
            
        prev = self.find(self.storage[idx],key)
        
        if(prev.next == None):
            prev.next = Node(key,value)
        else:
            prev.next.val = value
        
 
    
    def find(self, node,key):
        prev = None
        curr = node
        
        while(curr != None and curr.key!= key):
            prev = curr
            curr = curr.next
            
        return prev
        

    def get(self, key: int) -> int:
        idx = self.hash_fn(key)
        
        if(self.storage[idx]== None):
            return -1
        
        prev = self.find(self.storage[idx],key)
        
        if(prev.next == None):
            return -1
        else:
            return prev.next.val 
        
        
        

    def remove(self, key: int) -> None:
        
        idx = self.hash_fn(key)
        
        if(self.storage[idx]== None):
            return
        
        prev = self.find(self.storage[idx],key)
        
        if(prev.next == None):
            return 
        
        prev.next = prev.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)