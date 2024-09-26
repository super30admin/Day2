# # // Time Complexity : O(1)
# # // Space Complexity : O(1)
# # // Did this code successfully run on Leetcode : yes

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.bucketsize = 10000
        self.buckets = [None]*self.bucketsize
    
    def getBucket(self, key):
        return key%self.bucketsize
    
    def find(self, node, key):
        prev = node
        current = node.next
        while current is not None and current.key!= key:
            prev = current
            current = current.next
        return prev

    def put(self, key: int, value: int) -> None:
        idx = self.getBucket(key)
        # when bucket is empty
        if self.buckets[idx] is None:
            self.buckets[idx] = Node(-1,-1)
        # when bucket exist
        prev = self.find(self.buckets[idx], key)
        
        #when key is not present in that idx
        if prev.next is None:
            prev.next = Node(key,value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        idx = self.getBucket(key)
        # when bucket is empty
        if self.buckets[idx] is None:
            return -1
        prev = self.find(self.buckets[idx], key)
         
        if prev.next is None:
            return -1
        else:
            return prev.next.value

    def remove(self, key: int) -> None:
        idx = self.getBucket(key)
        # when bucket is empty
        if self.buckets[idx] is None:
            return
        prev = self.find(self.buckets[idx], key)
        if prev.next is None:
            return
        else:
            prev.next = prev.next.next
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)