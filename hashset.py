# Leetcode Problem 2:(https://leetcode.com/problems/design-hashset/)
# Tried to implement using linked list - got errors. will try again
# Single hashing technique


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashNumber = 1003
        self.hashSet = [[] for _ in range(self.hashNumber)]

    # Hashing function to return an index number
    def hashFunc(self, key):
        return (key % self.hashNumber)
    
    
    def add(self, key: int) -> None:
        index = self.hashFunc(key)
        if not self.contains(key):
            self.hashSet[index].append(key)
        
    def remove(self, key: int) -> None:
        index = self.hashFunc(key)
        if not self.hashSet[index]:
            return
        else:
            if key not in self.hashSet[index]:
                return
        self.hashSet[index].remove(key)
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index = self.hashFunc(key)
        if not self.hashSet[index]:
            return False
        else:
            return (key in self.hashSet[index])                
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)