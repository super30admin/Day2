# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this:
# Was getting index out of bound error for remove function when prev is still None.
# Also, was a bit lost on how to handle the remove for 1st element/head in linked list. Then used dummy node at head

class NodeList:
    def __init__(self, key=None, value=None, next=None):
        self.key = key
        self.value = value
        self.next = next


class MyHashMap:
    def __init__(self):
        self.py_size = 1000
        self.py_array = [None] * self.py_size

    def hash(self, key):
        return key % self.py_size

    def put(self, key, value):
        py_index = self.hash(key)
        if self.py_array[py_index] is None:
            self.py_array[py_index] = NodeList(-1, -1)
        curr = self.py_array[py_index]
        while curr.next is not None:
            if curr.next.key == key:
                curr.next.value = value
                return
            curr = curr.next
        curr.next = NodeList(key, value)

    def remove(self, key):
        py_index = self.hash(key)
        curr = self.py_array[py_index]
        prev = None
        while curr is not None:
            if curr.key == key:
                prev.next = curr.next
            prev = curr
            curr = curr.next

    def get(self, key):
        py_index = self.hash(key)
        curr = self.py_array[py_index]
        while curr is not None:
            if curr.key == key:
                return curr.value
            curr = curr.next
        return -1






