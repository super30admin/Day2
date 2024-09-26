#Time Complexity : O(n) to look up
#Space Complexity : O(n) size of the hash table
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 


#Your code here along with comments explaining your approach


class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.hash_table = [None] * self.size
    #creating our hash function
    def hash(self, key):
        return key % self.size
    
    def add(self, key: int) -> None:
        hash_value = self.hash(key)
        if self.hash_table[hash_value] is None:
            self.hash_table[hash_value] = [key]
        else:
            self.hash_table[hash_value].append(key)
        

    def remove(self, key: int) -> None:
        hash_value = self.hash(key)
        if self.hash_table[hash_value] is not None:
            while key in self.hash_table[hash_value]:
                self.hash_table[hash_value].remove(key)
                

    def contains(self, key: int) -> bool:
        hash_value = self.hash(key)
        if self.hash_table[hash_value] is not None:
            return key in self.hash_table[hash_value]
        return False
        