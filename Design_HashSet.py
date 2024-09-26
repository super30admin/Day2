
# Time Complexity : O(1)
# Space Complexity :  O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No.

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket = 1001
        self.bucketItems = 1000
        self.hashSet = [[] for _ in range(self.bucket)]
    
    def __bucket(self, key: int):
        
        return int(key%self.bucket)
    
    def __bucketItems(self, key: int):
        
        return int(key/self.bucketItems)

    def add(self, key: int) -> None:
        bucket = self.__bucket(key)
        bucketItems = self.__bucketItems(key)
        if(self.hashSet[bucket]==[]):
            self.hashSet[bucket] = [False]*self.bucketItems
        self.hashSet[bucket][bucketItems] = True
        S
    def remove(self, key: int) -> None:
        bucket = self.__bucket(key)
        bucketItems = self.__bucketItems(key)
        if(self.hashSet[bucket] == []):
            return 
        self.hashSet[bucket][bucketItems] = False
        
    def contains(self, key: int) -> bool:
        bucket = self.__bucket(key)
        bucketItems = self.__bucketItems(key)
        if(self.hashSet[bucket] == []):
            return False
        return self.hashSet[bucket][bucketItems]    

        
    
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)