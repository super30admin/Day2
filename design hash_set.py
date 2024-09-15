# Time Complexity: O(1) for every operation, O(n) for contains(value)
# Space Complexity: O(n) for storing the array.

# Did this code successfully run on Leetcode :No
# Any problem you faced while coding this : deletion of the key was hard to implement


class ListNode:
    def __init__(self,key,next):
        self.next = next
        self.key = key

class MyHashSet:

    def __init__(self):
        self.capacity = 1000
        self.array = [None]*self.capacity
        
    def add(self, key: int) -> None:
        
        index = key%self.capacity
        # check if index has anything in it or not
        # 1. Noting is there
        if self.array[index]==None:
            self.array[index] = ListNode(key,True)
            return
        
        # 2. something is already present
        curr = self.array[index]
        # If key already present, do nothing
        if curr.key==key:
            return
        # If there are nodes at given index then traverse the linked-list and attach the key at the end.
        while curr:
            if not curr.next:
                curr.next = ListNode(key,None)
                return
            if curr.next: 
                curr = curr.next
        return    
        
    def remove(self, key: int) -> None:
        
        index = key % self.capacity
        curr = self.array[index]
        # if there is noting to pop, just return it.
        if not curr:
            return 
        curr = self.array[index]
    
        # if key to be poped is present in later of LL
        while curr:
            if curr.key == key:
                curr.next = False
                break
            curr = curr.next
        
    def contains(self, key: int) -> bool:
        
        index = key % self.capacity
        curr = self.array[index]
        
        # Just traverse the whole curr
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