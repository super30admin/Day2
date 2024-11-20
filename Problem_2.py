#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Aug 26 18:23:26 2021

@author: ameeshas11
"""

#Time Complexity : O(1)
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
    

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list_1 = [0]*1000
        

    def add(self, key: int) -> None:
        key_1 = key%1000
        key_2 = key//1000
        if self.list_1[key_1] == 0:
            if key_1 == 0:
                self.list_2 = [False]*1001
            else:
                self.list_2 = [False]*1000
            self.list_2[key_2] = True
            self.list_1[key_1] = self.list_2
        else:
            list_2 = self.list_1[key_1]
            list_2[key_2] = True

    def remove(self, key: int) -> None:
        key_1 = key%1000
        key_2 = key//1000
        if self.list_1[key_1] != 0:
            list_2 = self.list_1[key_1]
            list_2[key_2] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        key_1 = key%1000
        key_2 = key//1000
        if self.list_1[key_1] == 0:
            return False
        else:
            list_2 = self.list_1[key_1]
            return list_2[key_2]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)