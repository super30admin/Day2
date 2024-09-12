# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach
#APPROACH - DOUBLE HASHING 

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #Create a boolean array , decide bucket size using sqrt function
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [[None for i in range(self.bucketItems)]for j in range(self.buckets)]
    
    #calculate index for primary array 
    def chooseBucket(self,key):
        return key%self.buckets
    
    #calculate index for secondary array
    def chooseBucketItem(self,key):
        return key//self.bucketItems
                

    def add(self, key: int) -> None:
        b = self.chooseBucket(key)
        bi = self.chooseBucketItem(key)
        
        #no secondary array is not present, create it
        if self.storage[b]==None:        
            #handle edge case -> key = 1000000
            if b==0:
                self.storage[b] = self.storage[self.bucketItems+1]
            else:
                self.storage[b] = self.storage[self.bucketItems]
        self.storage[b][bi] = True
            
        
    def remove(self, key: int) -> None:
        b = self.chooseBucket(key)
        bi = self.chooseBucketItem(key)
        
        if self.storage[b] == None:
            return
        
        # switch value to False to remove the key
        self.storage[b][bi] = False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        b = self.chooseBucket(key)
        bi = self.chooseBucketItem(key)
        if self.storage[b] == None:
            return 
        return self.storage[b][bi]
    
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)


hashSet = MyHashSet()
hashSet.add(1);         
hashSet.add(2);         
print(hashSet.contains(1));    # returns true
print(hashSet.contains(3));    # returns false (not found)
hashSet.add(2);          
print(hashSet.contains(2));    # returns true
hashSet.remove(2);          
