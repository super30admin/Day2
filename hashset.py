# Time Complexity : Add - O(1), contains() - O(1)
# Space Complexity : O(n^2) - Worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

'''
I have used a Double hash methodolgy, but somehow for the python version, the leetcode suggested that my code was better than only 48% python solution. I don't understand why is that and what could still be lacking, I thought of using Chain doubling
along with double hashing but by doing that the double hash function would NOT be advantageous in terms of avoiding collision with given range of 0-1000000

'''

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.buckets_size = 1000
        self.bucketItems_size = 1000 + 1 
        self.buckets = [None]*self.buckets_size  
        

    def get_hash(self, key):
        
        hashed_key = key % self.buckets_size
        hashed_key_item = key % self.bucketItems_size
        return (hashed_key, hashed_key_item)
        
        
    def add(self, key: int) -> None:
        
        hashed_key, hashed_key_item = self.get_hash(key)
        
        if self.buckets[hashed_key] is None:
            self.buckets[hashed_key] = [False] * self.bucketItems_size
        
        self.buckets[hashed_key][hashed_key_item] = True
                  
            
    def remove(self, key: int) -> None:
        
        hashed_key, hashed_key_item = self.get_hash(key)
        
        if self.buckets[hashed_key]:
            self.buckets[hashed_key][hashed_key_item] = False
                            
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashed_key, hashed_key_item = self.get_hash(key)
        
        if self.buckets[hashed_key]:
            return self.buckets[hashed_key][hashed_key_item]
        else:
            return False
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)