# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None
class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.Array = [None] * (self.size + 1) 

    def get_Hash(self, key):
        return key % self.size

    def find_Prev(self, index, key):
        prev = self.Array[index]
        curr = prev
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        index = self.get_Hash(key)
        if self.Array[index] == None:
            self.Array[index] = Node(-1,-1)
        prev = self.find_Prev(index, key)
        if prev.next is None:
            prev.next = Node(key, value)
        else :
            prev.next.val = value

    def get(self, key: int) -> int:
        index = self.get_Hash(key)
        if self.Array[index] == None:
            return -1
        prev = self.find_Prev(index, key)
        if prev.next is None:
            return -1
        else :
            return prev.next.val

    def remove(self, key: int) -> None:
        index = self.get_Hash(key)
        if self.Array[index] == None:
            return -1
        prev = self.find_Prev(index, key)
        if prev.next is None:
            return -1
        else :
            prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)