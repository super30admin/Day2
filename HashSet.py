class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = [None for x in range(1000)]
        
        
    #complexity is O(1)
    def add(self, key: int) -> None:
        if(self.arr[key%1000]==None):
            self.arr[key%1000]=[None for x in range(1000)]
        self.arr[key%1000][key//1000]=True

    #complexity is O(1)
    def remove(self, key: int) -> None:
         if self.arr[key%1000]:
            if self.arr[key%1000][key//1000]!=None:
                self.arr[key%1000][key//1000]=False
        
    #complexity is O(1)
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if self.arr[key%1000]!= None:
            if self.arr[key%1000][key//1000]!=None:
                return self.arr[key%1000][key//1000]
            else:
                return False
        else:
            return False
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
