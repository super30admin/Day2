# // Time Complexity : O(n/k) n is no.of all possible values and k is no.of buckets.
# // Space Complexity : O(m+k) m is predefined buckets and k is inserted values.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No



class MyHashSet(object):

    def __init__(self):
        self.keyrange = 769
        self.bucketArray = [Bucket() for i in range(self.keyrange)]
        
    def _hash(self,key):
        return key % self.keyrange    

    def add(self, key):
        bucketindex = self._hash(key)
        self.bucketArray[bucketindex].insert(key)
        
    def remove(self, key: int) -> None:
        index = self._hash(key)
        self.bucketArray[index].delete(key)

    def contains(self, key: int) -> bool:
        index = self._hash(key)
        return self.bucketArray[index].exists(key)
        
        
class Node:
    def __init__(self, value, nextNode=None):
        self.value = value
        self.next = nextNode
        
class Bucket:
    def __init__(self):
        self.head = Node(0)
        
    def insert(self,newValue):
        if not self.exists(newValue):
            newNode = Node(newValue, self.head.next)
            self.head.next = newNode
            
    def delete(self,value):
        prev = self.head
        cur = self.head.next
        while cur is not None:
            if cur.value == value:
                prev.next = cur.next
                return
            prev = cur
            cur = cur.next
            
    def exists(self, value):
        cur = self.head.next
        while cur is not None:
            if cur.value == value:
                return True
            cur = cur.next
        return False

        
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)