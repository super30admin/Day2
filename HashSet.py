# Problem 2: (https://leetcode.com/problems/design-hashset/)
# Time complexity: O(N/k); N=number of all possible keys, k=size of table
# Space complexity: O(k+M); k=size of table, M=number of unique keys inserted in linkedlists
# Did this code successfully run on Leetcode : Yes
# Approach: Used separate chaining technique: Array + LinkedList

class ListNode:
    def __init__(self, key):
        """
        Initialize your data structure here.
        """
        self.key = key
        self.next = None #linkedlist next pointer

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.m = 997
        self.h = [None] * self.m
        

    def add(self, key: int) -> None:
        index = key % self.m
        if self.h[index] == None:
            self.h[index] = ListNode(key)
        else:
            cur = self.h[index]
            while True:
                if cur.key == key:
                    return
                if cur.next == None:
                    break
                cur = cur.next
            cur.next = ListNode(key)

    def remove(self, key: int) -> None:
        index = key % self.m
        cur = prev = self.h[index]
        if cur == None:
            return
        if cur.key == key:
            self.h[index] = cur.next
        else:
            cur = cur.next
            while cur:
                if cur.key == key:
                    prev.next = cur.next
                    break
                else:
                    cur = cur.next
                    prev = prev.next

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index = key % self.m
        if self.h[index] == None:
            return False
        cur = self.h[index]
        if cur.key == key:
            return True
        else:
            cur = cur.next
            while cur:
                if cur.key == key:
                    return True
                else:
                    cur = cur.next
            return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)