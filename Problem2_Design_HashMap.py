# Time Complexity : O(1) for all operations
# Space Complexity : O(n) where n is the number of keys possible
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

### DESIGNING HASH MAP ###

class MyHashMap:

    def __init__(self):
        self.buckets = 1000 # Size of buckets, chose 1000 as we can evenly split 10^6
        self.hashMap = [None]*self.buckets # Initialize hashMap of size of buckets with None
    
    def hash1(self,key:int) -> int:
        return key%self.buckets
    # First hash function is modulo of key with buckets. We use this to find which index of hashMap we have to use
    
    def hash2(self,key:int) -> int:
        return key//self.buckets
    # Second hash function is division of key with buckets. We use this to find which index of the array inside hashMap[hash1] we have to use

    def put(self, key: int, value: int) -> None:
        hash1 = self.hash1(key) # Calculate hash1 and hash2 values
        hash2 = self.hash2(key)
        if not self.hashMap[hash1]: # If an array does not exist we create an array of size buckets filled with False
            if hash1 == 0:
                self.hashMap[hash1] = [False]*(self.buckets+1) # +1 Since the upper limit (here 10^6) should also be accomodated
            else:
                self.hashMap[hash1] = [False]*self.buckets
        self.hashMap[hash1][hash2] = value # We add the value at hashMap[hash1][hash2]

    def get(self, key: int) -> int:
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        if not self.hashMap[hash1]: # Return if there is no array at hashMap[hash1]
            return -1
        if self.hashMap[hash1][hash2]==False and isinstance(self.hashMap[hash1][hash2],bool):
            return -1 # Return if there is no value at hashMap[hash1][hash2]
        return self.hashMap[hash1][hash2]

    def remove(self, key: int) -> None:
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        if not self.hashMap[hash1]:
            return # Return if there is no array at hashMap[hash1]
        self.hashMap[hash1][hash2] = False # Remove the value at the key by making it False
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)