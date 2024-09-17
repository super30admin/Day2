# Time Complexity : O(1)
# Space Complexity : O(n) for the storage
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
'''
Here double hashing technique is used, with the help of boolean storage 1000 * 1000
with Edge case for the millionth entry as there 0-999 for the first 0th index
whenever the secondary array is not created we create one for the respective one
To remove, we make the respective row and col to False
To check contains, we check if the entry is True or False


'''
class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None for i in range(self.buckets)]
        
    def bucket(self, key:int) -> int:
        return key % self.buckets
    
    def bucketItem(self, key:int) -> int:
        return key // self.bucketItems
        
    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [False for i in range(self.bucketItems+1)]
            else:
                self.storage[bucket] = [False for i in range(self.bucketItems)]
        self.storage[bucket][bucketItem] = True
                
    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.storage[bucket] is None:
            return
        self.storage[bucket][bucketItem] = False
        
    def contains(self, key: int) -> bool:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.storage[bucket] is None:
            return False
        return self.storage[bucket][bucketItem]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
