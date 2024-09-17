"""
Python implementation of hash-set w/o in built hash libraries
Time complexity   : O(1)
Space Complexity  : O(N*M) N upto 1000 and M is upto 1000 
program did not run successfully, woudl appreciate help in debugging 
""" 

class MyHashSet:
    
    def __bucket(self, key: int) -> int:
        return key % self.__b
        
    def __bucketItems(self, key: int) -> int:
        return key/self.__bI
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.__storage = [[None] * 1000 for i in range(1000)]   #Initialize a boolean 2 D matrix called storage
        self.__b = 1000           #contains the rows
        self.__bI = 1000          #contains the columns
        
    def add(self, key: int) -> None:
        self.__b = self.__bucket(key)
        self.__bI = self.__bucketItems(key)
        if self.__storage[self.__b] is None:
            self.__storage.append(self.__bI)
        self.__storage[self.__b][self.__bI] = True

    def remove(self, key: int) -> None:
        self.__b = self.___bucket(key)
        self.__bI = self.__bucketItems(key)
        if self.storage[self.__b] is None:
            return
        else:
            self.__storage[self.__b][self.__bI] = False
                  

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        self.__b = self.___bucket(key)
        self.__bI = self.__bucketItems(key)
        if self.storage[self.__b] is None:
            return False
        else:
            return self.__storage[self.__b][self.__bI]        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)