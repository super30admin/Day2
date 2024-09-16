#brute force
#time Comp- O(1) all operations
#space- O(n) size of list
class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.h = [-1 for i in range(1000000)]
        
    def add(self, key: int) -> None:
        self.h[key]=True
        
        

    def remove(self, key: int) -> None:
        self.h[key]=False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if self.h[key]==True:
            return True
        else:
            False
            
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
