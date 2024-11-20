# Time Complexity : add:- average case:-O(1)/worst case:- O(n/c), c=no. of chains=997 remove:- amortized cost:- O(1), worst case:- O(n/c) contains:- average case:-O(1)/worst case:- O(n/c)
# Space Complexity : O(c)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Similar to Hashmap using a fixed number of slots which is a prime number less than 1000, and naively using a array to resolve collisions.
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.my_hashset=[-1]*997
        

    def add(self, key: int) -> None:
        hash=key%997
        if self.contains(key):
            return
        if self.my_hashset[hash]==-1:
            self.my_hashset[hash]=[key]
        else:
            self.my_hashset[hash].append(key)

    def remove(self, key: int) -> None:
        hash=key%997
        if self.my_hashset[hash]!=-1:
            for i in range(len(self.my_hashset[hash])):
                if self.my_hashset[hash][i]==key:
                    self.my_hashset[hash].pop(i)
                    break
                    
                    

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hash=key%997
        if self.my_hashset[hash]!=-1:
            for i in range(len(self.my_hashset[hash])):
                if self.my_hashset[hash][i]==key:
                    return True
        return False
        