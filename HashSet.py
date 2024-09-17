# Time Complexity : O(N / K)
# where N is the number of unique values to be inserted and K is the number of predefined buckets.
# So assuming uniform distribution of values, the time taken for the operations involve getting the bucket (1/k)
# and scanning the bucket which in worst-case will have N values.

# Space Complexity : O(N + K)
# where N is the number of unique values to be inserted and K is the number of predefined buckets.


# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
# Initializin Node class to hold the value and the address of the next node in the list
class Node:
    def __init__(self, key):
        self.key = key
        self.next = None

# LinkList class has all the operations required to operate on the linked list including insert, delete and contains functions.
class LinkList:
    def __init__(self):
        self.head = Node(-1)

    def insert(self, key):
        current = self.head
        while (current.next != None):
            if current.key == key:
                return
            else:
                current = current.next
        if (current.key != key):
            current.next = Node(key)

    def delete(self, key):
        prev = self.head
        current = self.head.next
        while (current != None):
            if current.key == key:
                prev.next = current.next
                return
            prev = current
            current = current.next

    def exist(self, key):
        current = self.head.next
        while (current != None):
            if current.key == key:
                return True
            current = current.next
        return False


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # The self.hash indicates the number of pre-defined buckets.
        self.hash = 769
        # The self.hasSet is the bucket list where each bucket is implemented as linked list.
        self.hashSet = [LinkList() for i in range(self.hash)]

    def add(self, key: int) -> None:
        index = key % self.hash
        self.hashSet[index].insert(key)

    def remove(self, key: int) -> None:
        index = key % self.hash
        self.hashSet[index].delete(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index = key % self.hash
        return self.hashSet[index].exist(key)

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)