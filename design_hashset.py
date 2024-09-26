"""
// Time Complexity : 
    add - O(1)
    contains - O(1)
    remove -  O(1)

// Space Complexity : 
    O(n) for using array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
- Initialize hashtable with size 13, Each index holds a pointer to head of doubly linked list
- Define a hash function using prime number modulo for given key
- add
    Get the hash value of the key to be inserted(index)
    add the value at the obtained index and append the element at tail of the linked list
    only if the value is not present in the list
- contains
    - Get the hash value of the key to be fetched
    - Iterate along the linked list till the element is found - return True
    - else return False
- remove
    - Get the hash value of the key to be removed
    - Iterate along the linked list till the value is found, delete the node using prev and next pointers
"""
class Node:
    def __init__(self,key):
        self.prev = None
        self.next = None
        self.key = key

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashtable = [None]*13
        self.prime_mod = 13

    def get_hash_value(self,key):
        return key % self.prime_mod
    
    def print_list(self,head):
        curr = head
        while curr:
            #print((curr.key,curr.value),end = " ")
            curr = curr.next
        

    def add(self, key: int) -> None:
        hv = self.get_hash_value(key)
        newnode = Node(key)
        if not self.hashtable[hv]:
            self.hashtable[hv] = newnode
            self.hashtable[hv].next = None
            self.hashtable[hv].prev = None
        else:
            curr = self.hashtable[hv]
            #find for the key 
            update = False
            while curr:
                if curr.key == key:
                    #curr.value = value
                    return
                curr = curr.next
            if not update:
                newnode.next = self.hashtable[hv].next
                if self.hashtable[hv].next:
                    self.hashtable[hv].next.prev = newnode
                newnode.prev = self.hashtable[hv]
                self.hashtable[hv].next = newnode

    def remove(self, key: int) -> None:
        hv = self.get_hash_value(key)
        curr = self.hashtable[hv]
        while curr:
            if curr.key == key:
                #print("KEy to remove found",key)
                break
            curr = curr.next
        
        if curr:
            #print("curr value",curr.key,curr.value)
            if not curr.prev:
                self.hashtable[hv] = self.hashtable[hv].next
                if self.hashtable[hv]:
                    self.hashtable[hv].prev = None
            else:
                currprev = curr.prev
                #print(currprev.key,currprev.value)
                currnext = curr.next
                currprev.next = currnext
                if currnext:
                    #print(currnext.key,currnext.value)
                    currnext.prev = currprev

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hv = self.get_hash_value(key)
        curr = self.hashtable[hv]
        #print("GET ME THE KEY",key)
        while curr:
            #print("Keys in the get for the key",curr.key)
            if curr.key == key:
                return True
                #print("KEy to fetch found for value",key,value)
            curr = curr.next
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)