
# time complexity = O(1)
# space complexity - O(n)
# executed on Leetcode
# using an array of size 10k as parent datastructure and usinglinked list for linear chaining of max length 100
# that makes the time complexity O(1)
# Using a dummy node for the start node for prev
# using a search function to find the prev and current node with target key

class Node:
    def __init__(self,key,value,next=None):
        self.key = key
        self.value = value
        self.next = next

class MyHashMap:

    def __init__(self):
        self.buckets = 10000
        self.storage = [None]*(self.buckets)
        
        
    def get_bucket(self, key):
        return key % self.buckets

    def search(self, bucket, key):
        prev = None
        cur = self.storage[bucket]
        while cur and cur.key != key:
            prev = cur
            cur = cur.next
        return prev

    def put(self, key: int, value: int) -> None:
        bucket = self.get_bucket(key)
        if not self.storage[bucket]:
            self.storage[bucket] = Node(-1,-1) # create dummy node
        prev = self.search(bucket, key)
        if prev.next:
            prev.next.value = value
        else:
            prev.next = Node(key, value)

    def get(self, key: int) -> int:
        bucket = self.get_bucket(key)
        if not self.storage[bucket]:
            return -1
        prev = self.search(bucket, key)
        if prev.next:
            return prev.next.value
        return -1
        

    def remove(self, key: int) -> None:
        bucket = self.get_bucket(key)
        if not self.storage[bucket]:
            return 
        prev = self.search(bucket, key)
        if prev.next:     
            prev.next = prev.next.next
        

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)