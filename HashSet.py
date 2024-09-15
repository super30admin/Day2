
# // Time Complexity :O(1)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
# type errors and syntactical changes 

# // Your code here along with comments explaining your approach
class MyHashSet:

    def __init__(self):
        
        self.bucketSize = 1000
        self.bucketItemsSize =1000
        self.storage = [None]*self.bucketSize
        
    def bucket(self, key : int) -> int:
        return key % self.bucketSize
    
    def bucketItem(self, key: int) -> int:
        return key // self.bucketItemsSize

    def add(self, key: int) -> None:
        bucketnum = self.bucket(key)
        bucketItemnum = self.bucketItem(key)
        if self.storage[bucketnum] == None:
            if bucketnum == 0:
                self.storage[bucketnum] = [0]*(self.bucketItemsSize+1)
            else: 
                self.storage[bucketnum] = [0]*(self.bucketItemsSize)
                
        self.storage[bucketnum][bucketItemnum] = True
            

    def remove(self, key: int) -> None:
        bucketnum = self.bucket(key)
        bucketItemnum = self.bucketItem(key)
        if self.storage[bucketnum] == None:
            return None
        
        self.storage[bucketnum][bucketItemnum] = False
        
    def contains(self, key: int) -> bool:
        bucketnum = self.bucket(key)
        bucketItemnum = self.bucketItem(key)
        if self.storage[bucketnum] == None:
            return False
        return self.storage[bucketnum][bucketItemnum]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(2)
# param_3 = obj.contains(2)
# obj.remove(2)