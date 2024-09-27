# Time Complexity : 
#  TC for find -> O(bucket Items) Bucket Items is number of 
# unique elements inserted in a bucket
# Space Complexity :
#  O(no of buckets * unique values interted in separate chained buckets)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Design HashMap using Separate Chaining
class MyHashMap:
    
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None
        

    def __init__(self):
        self.buckets = 10000
        self.nodes = [[]]*self.buckets
    
    
    def getBucket(self, key):
        return key%self.buckets
    
    def find(self, node, key):
        prev = node
        current = node.next
        while(current != None and current.key != key):
            prev = current
            current = current.next
        return prev
        

    def put(self, key: int, value: int) -> None:
        index = self.getBucket(key)
        if not self.nodes[index]:
            self.nodes[index] = self.Node(-1, -1)
        prev = self.find(self.nodes[index], key)
        if not prev.next:
            prev.next = self.Node(key, value)
        else:
            prev.next.value = value
        
 
    def get(self, key: int) -> int:
        index = self.getBucket(key)
        if not self.nodes[index]:
            return -1
        prev = self.find(self.nodes[index], key)
        if not prev.next:
            return -1
        return prev.next.value
    
    
    def remove(self, key: int) -> None:
        index = self.getBucket(key)
        if not self.nodes[index] :
            return           
        prev = self.find(self.nodes[index], key)
        if not prev.next:
            prev.next = None
            return
        prev.next = prev.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)