// Hashmap using chaining, first array is initialized for the buckets and then node list is used for bucket items 
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Node:  

    def __init__(self,key, value):
        self.key = key
        self.value = value
        self.next = None  

class MyHashMap:
    def __init__(self):
        self.buckets= 1000
        self.storage= [None]* self.buckets

    def find(self, dummy,key):
        prev= dummy
        curr = dummy.next
        while(curr!= None) and(curr.key != key):
            prev = curr
            curr= curr.next
        return prev
    
    def put(self, key: int, value: int) -> None:
        bucket = (key)%(self.buckets)
        print(bucket)
        if(self.storage[bucket] == None):
            self.storage[bucket] = Node(-1,-1)
        prev = self.find(self.storage[bucket],key)
        if(prev.next == None):
            prev.next= Node(key, value)
            return
        prev.next.value = value
        

    def get(self, key: int) -> int:
        bucket = key%self.buckets
        if(self.storage[bucket] == None):
            self.storage[bucket] = Node(-1,-1)
        prev = self.find(self.storage[bucket],key)
        if(prev.next == None):
            return -1
        return prev.next.value

        

    def remove(self, key: int) -> None:
        bucket = key%self.buckets
        if(self.storage[bucket] == None):
            return
        prev = self.find(self.storage[bucket],key)
        if(prev.next == None):
            return
        prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
