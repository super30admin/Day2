// Time Complexity : O(1) Best , O(N/1000) worst time complexity
// Space Complexity : O(N) where N is the number of items in the dictionary
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ListNode:
    def __init__(self, val, nxt= None):
        self.val = val
        self.next = nxt
        
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.m = 1000
        self.hash = [None]*self.m
        
    def find(self,key):
        index = key%self.m
        cur = self.hash[index]
        while cur:
            if cur.val == key:
                return True
            cur = cur.next
        return False
        
    def add(self, key: int) -> None:
        if self.find(key):
            return
        index = key%self.m
        oldhead = self.hash[index]
        head = ListNode(key,oldhead)
        self.hash[index] = head
            
            
        

    def remove(self, key: int) -> None:
        index= key%self.m
        head= self.hash[index]
        if head is not None: 
            if head.val == key:
                self.hash[index] = head.next
                return
            
            prev, cur = head,head.next
            while cur:
                if cur.val == key:
                    prev.next = cur.next
                    break
                prev,cur = prev.next,cur.next
        return
                
    
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return self.find(key)