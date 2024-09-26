# -*- coding: utf-8 -*-
"""
Created on Tue Feb  4 14:16:59 2020

@author: WELCOME
"""
"""
Working on Leetcode
Time complexity of all operations = O(1)
Space Complexity=O(Not sure)
"""
class MyHashSet:

    def __init__(self):
        self.hash=[None]*1000
        """
        Initialize your data structure here.
        """
    def hashMod(self,num):
        return num%1000
    def hashDiv(self,num):
        return num//1000

    def add(self, key: int) -> None:
        hashMod=self.hashMod(key)
        hashDiv=self.hashDiv(key)
        if self.hash[hashMod]==None:
            self.hash[hashMod]=[None]*1000
        self.hash[hashMod][hashDiv]=True
            
        
        

    def remove(self, key: int) -> None:
        hashMod=self.hashMod(key)
        hashDiv=self.hashDiv(key)
        if self.hash[hashMod]:
            self.hash[hashMod][hashDiv]=False
        
        

    def contains(self, key: int) -> bool:
        hashMod=self.hashMod(key)
        hashDiv=self.hashDiv(key)
        if self.hash[hashMod]:
            if self.hash[hashMod][hashDiv]:
                return True
        return False
        """
        Returns true if this set contains the specified element
        """
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)