"""
## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
"""

class ListNode:
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.size = 10000
        self.hash_map = [ListNode(-1, -1) for _ in range(self.size)]
        
        
        
    def findKey(self, node, key):
        prev = None
        curr = node
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
            
        return prev
            

    
    def put(self, key: int, value: int) -> None:
        index = key % self.size
        exist_node = self.findKey(self.hash_map[index], key)
        if exist_node.next==None:
               exist_node.next = ListNode(key,value)
        else:
            exist_node.next.value = value
            
        
        

    def get(self, key: int) -> int:
        index = (key % self.size)
        
        node = self.findKey(self.hash_map[index], key)
        
        if node and node.next:
            return node.next.value
        
        return -1
        

    def remove(self, key: int) -> None:
        index = key % self.size
        if self.hash_map[index]==None:
            return
        prev = self.findKey(self.hash_map[index], key)
        if prev.next:
            temp = prev.next
            prev.next = prev.next.next
            temp.next = None
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)