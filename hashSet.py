class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset = []

    def add(self, key: int) -> None:
        
        if key not in self.hashset:
            self.hashset.append(key)
        
    def remove(self, key: int) -> None:
        
        if key in self.hashset:
            self.hashset.remove(key)
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        
        if key in self.hashset:
            return True
        
        return False

hashSet = MyHashSet()
hashSet.add(1)       
hashSet.add(2)      
print(hashSet.contains(1))
print(hashSet.contains(3))
hashSet.add(2)        
print(hashSet.contains(2))
hashSet.remove(2)         
print(hashSet.contains(2))

'''
Time complexity: O(n):linear search to find if the element exists or not;
'''