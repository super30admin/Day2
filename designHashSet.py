# Time Complexity : O(N)....O(N/size) where N is the number of values and size is what I defined in my 
# constructor in MyHashSet class. O(N) nontheless
# Space Complexity : O(N) N= number of unique values..really O(N+ size) where size is what I 
# defined in my constructor in MyHashSet class, O(N) nontheless
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
#create node class that contains the value and the next pointer. Want to create an 
# array of linkedlists to avoid collisions. 
class Node:
    def __init__(self, val=None):
        self.val = val
        self.next = None
#O(N) time and space
class LL:
    def __init__(self):
        self.head = Node()
    #O(N)
    def search(self,key):
        curr = self.head 
        while curr:
            if curr.val == key:
                return curr
            curr = curr.next 
        return None
    #O(1)
    def add(self, key):
        curr = self.search(key)
        if curr:
            curr.val = key 
        else:
            newNode = Node(key)
            newNode.next = self.head.next 
            self.head.next = newNode
    #O(N)
    def delete(self, key):
        prev = self.head 
        curr = self.head.next 
        while curr:
            if curr.val == key:
                break #found key
            prev = curr
            curr = curr.next 
        if curr: #remove 
            prev.next = prev.next.next

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10000
        self.list = [LL() for i in range(self.size)]

    def add(self, key: int) -> None:
        hashing = key % self.size 
        
        self.list[hashing].add(key)
        
    def remove(self, key: int) -> None:
        hashing = key % self.size
        self.list[hashing].delete(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashing = key % self.size
        node = self.list[hashing].search(key)
        if node:
            return True 
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)