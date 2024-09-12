#  Time Complexity :O(1) for add o(n) for remove and contains
#  Space Complexity :
#  Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :Nope



class MyHashSet:

    def __init__(self):
        self.hashSize = 1000
        self.hashset = [[]]*self.hashSize
    def hashKey(self, val):
        index = val%self.hashSize
        return index
        

    def add(self, key: int) -> None:
        index = self.hashKey(key)
        if key in self.hashset[index]:
            pass
        else:
            self.hashset[index].append(key)
        
        

    def remove(self, key: int) -> None:
        index = self.hashKey(key)
        if key in self.hashset[index]:
            self.hashset[index].remove(key)
        else:
            pass
        

    def contains(self, key: int) -> bool:
        index = self.hashKey(key)

        if key in self.hashset[index]:
            return True
        else:
            return False
        

