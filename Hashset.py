""" 
Time Complexity : O(N/k) where N is total number of values and k is number of buckets
Space Complexity : O(k+U) k is number of buckets and U is total unique values 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach - First I have defined number of buckets by taking some large prime number
then I have implemented the linkedlist in each bucket to overcome the collisions
"""
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        
class LinkedList:
    def __init__(self):
        self.prehead = Node(None)
    
    def search(self, key):
        temp = self.prehead.next
        while temp is not None:
            if temp.data == key:
                return temp
            temp = temp.next
        return None
    
    def addElement(self, key):
        searchedNode = self.search(key)
        if searchedNode is None:
            NewNode = Node(key)
            NewNode.next = self.prehead.next
            self.prehead.next = NewNode
        else:
            searchedNode.data = key
    
    def delElement(self, key):
        prev = self.prehead
        cur = self.prehead.next
        while cur:
            if cur.data == key:
                prev.next = cur.next
                cur.next = None
                break
            prev = cur
            cur = cur.next
            
            
    
    
class MyHashSet:

    def __init__(self):
        self.key = 3833
        self.table = [LinkedList() for _ in range(self.key)]
        
        

    def add(self, key: int) -> None:
        index = key % self.key
        self.table[index].addElement(key)
        

    def remove(self, key: int) -> None:
        index = key % self.key
        self.table[index].delElement(key)
        

    def contains(self, key: int) -> bool:
        index = key % self.key
        node = self.table[index].search(key)
        if node is None:
            return False
        return True
        

