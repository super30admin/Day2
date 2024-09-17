# Time Complexity :amortized - get_hash: O(1), find_prev: O(1), put: O(1), get: O(1), remove: O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Yes, it was difficult to assign a linked list to each array node. Took 
# the help of internet to do that.


# Your code here along with comments explaining your approach

class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None
class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.Array = [None] * (self.size + 1) 

    # This will return the hash function for a key.
    def get_Hash(self, key):
        return key % self.size

    # This will find the previous node of the current node in the linked list. 
    def find_Prev(self, index, key):
        prev = self.Array[index]
        curr = prev
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    # this will insert the given key and value at the given hash function.
    def put(self, key: int, value: int) -> None:
        index = self.get_Hash(key)
        if self.Array[index] == None:
            self.Array[index] = Node(-1,-1)
        prev = self.find_Prev(index, key)
        if prev.next is None:
            prev.next = Node(key, value)
        else :
            prev.next.val = value

    # this will get the given key and value at the given hash function.
    def get(self, key: int) -> int:
        index = self.get_Hash(key)
        if self.Array[index] == None:
            return -1
        prev = self.find_Prev(index, key)
        if prev.next is None:
            return -1
        else :
            return prev.next.val
    # this will remove the given key and value at the given hash function.
    def remove(self, key: int) -> None:
        index = self.get_Hash(key)
        if self.Array[index] == None:
            return -1
        prev = self.find_Prev(index, key)
        if prev.next is None:
            return -1
        else :
            prev.next = prev.next.next
