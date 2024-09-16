# -*- coding: utf-8 -*-
"""
Time Complexity : add - O(1)
                  remove - O(1)
                  contains - O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None

Problem:
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:
add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
"""

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashmap = [None] * (1000000+1)     # very naive solution, reserving n number of space

    def add(self, key: int) -> None:
        self.hashmap[key] = key

    def remove(self, key: int) -> None:
        if self.hashmap[key] != None:
            self.hashmap[key] = None

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return self.hashmap[key] != None
    
hashSet = MyHashSet()
hashSet.add(1)         
hashSet.add(2)         
print(hashSet.contains(1))    # returns true
print(hashSet.contains(3))    # returns false (not found)
hashSet.add(2)          
print(hashSet.contains(2))    # returns true
hashSet.remove(2)          
print(hashSet.contains(2))    # returns false (already removed)