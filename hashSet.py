# Time complexity :- Add, Remove, Contain - On average 0(1), worst case O(n)

# Space compexity :- O(n)

# Runs on Leetcode :- Yes

# problems :- None. I don't feel this is the most optimized version. Also need some clarification
# if I should use linked list or list to solve this in Python


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.total_len = 1000
        self.hashList = [None] * self.total_len
        
    def getHash(self, key: int) -> int:
        return key % self.total_len

    def add(self, key: int) -> None:
        
        hashed_key = self.getHash(key)
        
        if self.hashList[hashed_key] is None:
            self.hashList[hashed_key] = [key]
            
        else:
            for existing_key in self.hashList[hashed_key]:
                if existing_key == key:
                    return
            self.hashList[hashed_key].append(key)
            

    def remove(self, key: int) -> None:
        
        hashed_key = self.getHash(key)
        
        if self.hashList[hashed_key] is None:
            return
            
        else:
            for index,existing_key in enumerate(self.hashList[hashed_key]):
                if existing_key == key:
                    self.hashList[hashed_key][index] = -1
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashed_key = self.getHash(key)
        
        if self.hashList[hashed_key] is None:
            return False
            
        else:
            for index,existing_key in enumerate(self.hashList[hashed_key]):
                if existing_key == key:
                    return True
                
            return False
               


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)