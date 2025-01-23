# Time Complexity : put, get, remove - amortized O(1)
# Space Complexity : O(l + n) l = length(buckets) n = keys inserted into hashmap
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach

# Created node and assigned -1 for both key and value, created a storage array 
# which is the primary array of length 10000 
# key is hashed to a bucket index using key % 10000 and 
# keys of the same buckets are stored as nodes of key value pair in a linked list




class Node: # creating node for a linkedlist
    def __init__(self,key = -1, value = -1, next=None):
        self.val = value
        self.key = key
        self.next = None

class MyHashMap:

    def __init__(self):
        # Hashmap initialization
        self.length = 10000
        self.storage = [Node() for i in range(self.length)]  #primary array

    def hash(self, key):
    # Simple hash function to map the key to an index
        return key % self.length
        
    def put(self, key: int, value: int) -> None:
        curr = self.storage[self.hash(key)] # Get the linked list for the bucket

        while curr.next: # traversal
            if curr.next.key == key: #if key already exists 
                curr.next.val = value #then unpdate its value
                return
            
            curr = curr.next # move to next node
        
        curr.next = Node(key,value) # if key doesn't exist then create a new node

    def get(self, key: int) -> int:
        curr = self.storage[self.hash(key)] # Get the linked list for the bucket
        while curr.next: # traversal
            if curr.next.key == key: #if key already exist then simply return its value
                return curr.next.val

            curr = curr.next # move to next node
        
        return -1 # return -1 if the key value doesn't exist
         
    def remove(self, key: int) -> None:
        curr = self.storage[self.hash(key)] # Get the linked list for the bucket
        while curr.next: # traversal
            if curr.next.key == key: # if key already exists 
                curr.next = curr.next.next # remove it by skipping the node
                return

            curr = curr.next # move to next node

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)