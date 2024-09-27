"""
Time : O(1+alpha) = O(1) where alpha = load factor = num of keys/num of slots
Space : O(n)

Approach:
Separate Chaining using  linked list
Create blocks with an array, each bucket has a linked list so you can delete and add in O(1) time. O(N) time for search.
"""


class ListNode(object):
    def __init__(self,key,next):
        self.key = key
        self.next = next

class HashSet(object):
    def __init__(self):
        self.size = 1000 #num of slots available in each blocks
        self.blocks = [None]*self.size
    
    def insert(self,key):
        index = key % self.size
        curr = self.blocks[index]
        if not curr: # Create a new node with key if curr is empty
            self.blocks[index] = ListNode(key,None)
        return
  
        while curr:
          if curr.key == key: #if key already exists, return
            return
          if not curr.next:
            cur.next = ListNode(key,None) #insert new key at the end
            return
          if cur.next:
            cur = cur.next
            return

    def delete(self,key):
        index = key%self.size
        curr = self.blocks[index]
        if not curr: 
            return
        if curr.key == key:
            self.blocks[index] = curr.next
        while curr.next:
            if curr.next.key == key:
                prev.next = curr.next.next
            return
            else:
                curr = curr.next
            return

    def contains(self,key):
        index = key%self.size
        curr = self.blocks[index]
        while curr:
            if curr.key == key:
                return True
            cur = cur.next
        return False
