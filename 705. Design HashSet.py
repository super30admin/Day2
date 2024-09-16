# -*- coding: utf-8 -*-
"""
Created on Sun Feb  6 00:15:51 2022

@author: BJay
"""
#Time Complexity : O(1)
#Space Complexity : O(n)
#Runs on leetcode fine

class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.set = [[None for _ in range(self.size)] for _ in range(self.size)]
        self.set[0].append(None)
        
    def ind1(self, key: int) -> int:
        return key % self.size
    def ind2(self,key: int) -> int:
        return key // self.size
       
    def add(self, key: int) -> None:
        i = self.ind1(key)
        if self.isBucketEmpty(i):
            j = self.ind2(key)
            self.set[i][j] = key

    def remove(self, key: int) -> None:
        i = self.ind1(key)
        if self.isBucketEmpty(i):
            j = self.ind2(key)
            self.set[i][j] = None
       

    def contains(self, key: int) -> bool:
        num1 = self.ind1(key)
        num2 = self.ind2(key)
        return self.set[num1][num2]
    
    def isBucketEmpty(self,i : int) -> bool:
        return bool(self.set[i])
