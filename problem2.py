# Time Complexity :  O(n)
# Space Complexity : O(n)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

#    Yes, my main programming lang is python so instruction was not clear

# Your code here along with comments explaining your approach


class MyHashSet:
 # using sets 
    def __init__(self):
        self.hsh = set([])
        
    def add(self, key: int) -> None:
        if not self.contains(key):
            self.hsh.add(key)     
    # set will have unique so add only if does not exist
    def remove(self, key: int) -> None:
        self.hsh.discard(key)
            
    def contains(self, key: int) -> bool:
        return (len(self.hsh&set([key])) == 1)  
    

