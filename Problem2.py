
'''
## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)
'''
'''
approach: 
A HashMap stores key-value pairs
Insert (put) a key-value pair
Retrieve (get) the value by key.
Remove (remove) a key from the map


working:
We take a key, apply a hash function, and get an index.
Store the value at that index.
when we need the value, we hash the key again and retrieve it.

(1, "apple"), (2, "banana"), (11, "grape")
hash(1)  -> index 1
hash(2)  -> index 2
hash(11) -> index 1 (collision!)

 Handling Collisions (Chaining Method)
 When two keys map to the same index, we store multiple values in a linked list at that index.


 

'''
class ListNode:
    def __init__(self,key,value):
        self.key=key
        self.value=value
        self.next=None
        
class MyHashMap:
    def __init__(self):
        self.size=10
        self.buckets=[None]*self.size
    
    def hash(self,key):
        return key%self.size
        
    def put(self, key: int, value: int) -> None:
        '''
        Find the index using the hash function.
        If the bucket is empty, create a new node
        If the key exists, update the value
        Otherwise, add a new node to handle collisions
        '''
        index= self.hash(key)
        if not self.buckets[index]:
            self.buckets[index]= ListNode(key,value)
        else:
            current=self.buckets[index]
            while current:
                if current.key==key:
                    current.value=value
                    return
                if not current.next:
                    break
                current=current.next
            current.next=ListNode(key,value)

    def get(self, key: int) -> int:
        '''
        Find the index using the hash function.
        Search through the linked list to find the key.
        If found, return the value; otherwise, return -1.
        '''
        index=self.hash(key)
        current=self.buckets[index]
        while current:
            if current.key==key:
                return current.value
            current=current.next
        return -1
        

    def remove(self, key: int) -> None:
        '''
        Find the index using the hash function.
        If key is found, remove the node.
        Adjust the linked list pointers accordingly.
        '''
        index=self.hash(key)
        current=self.buckets[index]
        prev=None
        while current:
            if current.key==key:
                if prev:
                    prev.next=current.next
                else:
                    self.buckets[index]=current.next
                return
            prev,current=current,current.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)