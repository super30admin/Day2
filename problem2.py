class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.lst=[None for i in range(10000)]
        
    def add(self, key: int) -> None:                                        #Time Complexity: O(100)
        a=key%1000
        b=int(key/1000)
        if not self.lst[a]:
            self.lst[a]=[False for i in range(100)]
        self.lst[a][b]=True
                

    def remove(self, key: int) -> None:                                       #Time Complexity: O(1)
        a=key%1000
        b=int(key/1000)
        if self.lst[a] and self.lst[a][b]==True:
            self.lst[a][b]=False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element                 #Time Complexity: O(1)
        """
        a=key%1000
        b=int(key/1000)
        if self.lst[a] and self.lst[a][b]==True:
            return True
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

// Did this code successfully run on Leetcode :Yes
//Space complexity: O(1000000)
