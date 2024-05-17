"""
Design-2

Problem 2:(https://leetcode.com/problems/design-hashmap/)

Time Complexity : O(n)
Space Complexity :  O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
To implement hashmap we're using chaining technique here. We can also use double hashing but problem with it is it consumes more memory since we create a array while the initial
creation of first element where as in chaining we create only when new element is being inserted which is not present in the chaining list so it consumes less memory compared to it.
Finding previous is the significant step here, initially we create a array of None of size 10^4, whenever we try to create a new element we find previous and if there is no previous then 
we create a dummy node and next insert the new node after it, if there is already element then we access it next & update the value. Similarly for get if we receive prev or prev.next as None then there
is no element else we return prev.next.data. For remove as well if we prev is not None or prev.next is not None then we assign the prev.next to it prev.next.next.
"""

class MyHashMap:

    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.buckets = 10000
        self.hash_map = [None] * self.buckets

    def hash1(self, key) -> int:
        return key % self.buckets

    def get_prev(self, key):
        hash1_val = self.hash1(key)
        if self.hash_map[hash1_val] is None:
            return None
        prev = self.hash_map[hash1_val]
        curr = prev.next

        while curr and curr.key != key:
            prev = curr
            curr = curr.next

        return prev
    
    def put(self, key: int, value: int) -> None:
        prev = self.get_prev(key)
        if prev is None:
            hash1_val = self.hash1(key)
            dummy = self.Node(-1, -1)
            self.hash_map[hash1_val] = dummy
            prev = self.hash_map[hash1_val]

        if prev.next is None:
            new_node = self.Node(key, value)
            prev.next = new_node
        else:
            prev.next.value = value
            
    def get(self, key: int) -> int:
        prev = self.get_prev(key)
        if prev is None or prev.next is None:
            return -1
        return prev.next.value

    def remove(self, key: int) -> None:
        prev = self.get_prev(key)
        if prev and prev.next is not None:
            prev.next = prev.next.next
        

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)