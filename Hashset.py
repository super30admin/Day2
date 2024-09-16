"""
## Problem 2:(https://leetcode.com/problems/design-hashset/)

Design a HashSet without using any built-in hash table libraries.
To be specific, your design should include these functions:

add(value): Insert a value into the HashSet.

contains(value) : Return whether the value exists in the HashSet or not.

remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.


"""
class Myhashset:
    def __init__(self):
        self.bucket = 1000
        self.bucketItem=1000
        self.hashset=[None]*self.bucket

    def bucketIndex(self,key):
        return key%self.bucket

    def bucketlistIndex(self,key):
        return key//self.bucketItem

    def add(self,key):
        index1=self.bucketIndex(key)
        index2= self.bucketlistIndex(key)

        if self.hashset[index1] ==None:
            self.hashset[index1] = [None]*self.bucketItem

        self.hashset[index1][index2] = True

    def remove(self, key: int) -> None:
        index1 = self.bucketIndex(key)
        index2 = self.bucketlistIndex(key)


    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index1 = self.bucketIndex(key)
        index2 = self.bucketlistIndex(key)
        return  self.hashset[index1] and self.hashset[index1][index2]
