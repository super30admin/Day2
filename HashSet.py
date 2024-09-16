# Design Hashset: https://leetcode.com/problems/design-hashset/
# Time complexity: O(N/k); N=number of all possible keys, k=size of table
# Space complexity: O(k+M); k=size of table, M=number of unique keys/values inserted in linkedlists
# Did this code successfully run on Leetcode : Yes
# Approach: Used separate chaining technique: Array + LinkedList

class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.capacity = 1000
        self.hashset = [None] * self.capacity
        
    def hash_function(self, key):
        return key % self.capacity

    def add(self, key: int) -> None:
        hash_val = self.hash_function(key)
        
        if self.hashset[hash_val] == None:
            self.hashset[hash_val] = ListNode(key)
        else:
            curr = self.hashset[hash_val]
            while True:
                if curr.key == key:
                    # curr.pair = (key,value)
                    break
                if curr.next == None:
                    curr.next = ListNode(key)
                    break  
                curr = curr.next    

    def remove(self, key: int) -> None:
        
        hash_val = self.hash_function(key)
        
        curr = prev = self.hashset[hash_val]
        
        if not curr:
            return 
        if curr.key == key:
            self.hashset[hash_val] = curr.next
        else:
            curr = curr.next
            while curr:
                if curr.key == key:
                    prev.next = curr.next
                    break
                else:
                    curr, prev = curr.next, prev.next
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash_val = self.hash_function(key)
        
        curr = self.hashset[hash_val]
        while curr:
            if curr.key == key:
                return True
            curr = curr.next
            
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)