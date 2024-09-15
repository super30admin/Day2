"""
Problem: Design Hashset (https://leetcode.com/problems/design-hashset/)
    - add(value): Insert a value into the HashSet.
    - contains(value) : Return whether the value exists in the HashSet or not.
    - remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
Solution:
    - Use Linked list as Bucket, because Array would take O(N) time complexity to remove or insert an element Vs O(1) for Linked list.
    - Hash function is the modulo operator, i.e. hash = value mod base
    - It is recommended to use a prime number as the base of modulo, e.g. 769, in order to reduce the potential collisions.
    - For each of the functions of add, remove and contains, we first generate the bucket index with the hash function.
Time Complexity: O(n/k), where
    - n is the number of all possible values and
    - k is the number of predefined buckets i.e. 769
Space Complexity: O(k+m), where
    - k is the number of predefined buckets and
    - m is the number of unique values that have been inserted into the hashset
"""


class MyHashSet(object):
    def __init__(self):
        # Initialize your data structure here
        self.keyRange = 769
        self.bucketArray = [Bucket() for i in range(self.keyRange)]

    def _hash(self, key):
        return key % self.keyRange

    def add(self, key):
        bucketIndex = self._hash((key))
        self.bucketArray[bucketIndex].insert(key)
        print("Inserted: ", key)

    def remove(self, key):
        bucketIndex = self._hash(key)
        self.bucketArray[bucketIndex].delete(key)
        print("Removed: ", key)

    def contains(self, key):
        # Returns true if this set contains the specified element
        bucketIndex = self._hash(key)
        print(key, "present or not?: ", self.bucketArray[bucketIndex].exists(key))


class Node:
    def __init__(self, data, next=None):
        self.data = data
        self.next = next


class Bucket:
    def __init__(self):
        self.head = Node(0)

    def insert(self, newValue):
        # if the val does not exist, add the new value to the head
        if not self.exists(newValue):
            newNode = Node(newValue, self.head.next)
            # set the new head
            self.head.next = newNode

    def delete(self, value):
        prev = self.head
        curr = self.head.next
        while curr is not None:
            if curr.data == value:
                # remove the current node
                prev.next = curr.next
                return
            prev = curr
            curr = curr.next

    def exists(self, value):
        curr = self.head.next
        while curr is not None:
            if curr.data == value:
                # value exists, return true
                return True
            curr = curr.next
        return False


# Driver Code:
obj = MyHashSet()
obj.add(2)
obj.add(3)
obj.add(4)
obj.remove(2)
obj.contains(4)
obj.contains(2)
