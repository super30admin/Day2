"""
// Time Complexity : O(n), where n is the number elements in a bucket
// Space Complexity : O(1), ptr variable is used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : developing the logic for bucket
"""

class Node(): #node class as bucket will be created using linkedlist
    def __init__(self, value):
        self.value = value
        self.next = None

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.cap=2069 # setting capacity
        #newNode= Node(0)
        self.my_set=[Node(-1) for i in range(self.cap)] #initializing the data structure with Nodes of value -1, with size = capacity
        

    def add(self, key: int) -> None:
        ind = key % self.cap #getting index through modulo
        
        node = Node(key) #creating node to be inserted

        if self.my_set[ind]: #if there are elements already existing at the index, we check for duplicate values
            if self.contains(key):
                return   

        node.next = self.my_set[ind] #add new node at the head
        self.my_set[ind]=node #change head ptr to point at the new node
                            
            
    def remove(self, key: int) -> None:
        ind = key % self.cap #getting index through modulo
        
        if self.my_set[ind]:
            
            if self.my_set[ind].value==key: #checking if key is present at the top 
                self.my_set[ind]=self.my_set[ind].next #making the head point to the next value

            else:
                ptr = self.my_set[ind] #else iterating over the linkedlist to find the value and remove it
                while ptr.next and ptr.next.next:
                    if ptr.next.value==key:
                        ptr.next=ptr.next.next
                        break
                    ptr=ptr.next


    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        ind = key % self.cap
        ptr = self.my_set[ind]
            
        while ptr: #iterate over the linkedlist to find the value
            if ptr.value==key:
                    return True
            ptr=ptr.next
        return False
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)