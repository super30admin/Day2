# time complexity = O(1)
# space complexity - O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
# using an array of size 10k initiated with None as parent datastructure then using LL for linear chaining of max length 100
# Using a dummy node for the start node for prev
# using a searchprev function to find the prev and current node with to find key

class Node:
        def __init__(self,key, value, next=None):
            self.key = key
            self.value = value
            self.next = next

class MyHashMap:
    
    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * self.buckets #initiating with a 10k array 

    def bucketfinder(self,key):
       return key%self.buckets 
     
    def searchprev(self,bucket, key):
        prev = None
        curr = self.storage[bucket]
        while(curr != None and curr.key != key):
            # if node found then we will have prev to curr else we will have last node.
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        bucket = self.bucketfinder(key)
        # No linkedList so creating dummy node at that place for search function
        if self.storage[bucket] == None:
            self.storage[bucket] = Node(-1, -1)
        # element exists then see if key is there in ht LL if there then replace else add new node
        prev = self.searchprev(bucket, key)
        if prev.next:
            prev.next.value = value
        else:
            prev.next = Node(key, value)   

    def get(self, key: int) -> int:
        bucket = self.bucketfinder(key)
        if self.storage[bucket] == None:
            return -1
        prev = self.searchprev(bucket, key)
        if prev.next:
            return prev.next.value
        return -1
        
    def remove(self, key: int) -> None:
        bucket = self.bucketfinder(key)
        if self.storage[bucket]:
            prev = self.searchprev(bucket, key)
            if prev.next:
                curr = prev.next
                prev.next = prev.next.next
                curr.next = None



        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)