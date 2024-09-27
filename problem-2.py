# Time Complexity : O(1)
# Space Complexity : O(1000) which is O(constant) So O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Double Hashing

class MyHashMap:

    def __init__(self):
        self.hashsize = 1000
        self.bucketsize = 1000
        self.hashmap = [None] * self.hashsize

    def hash1(self, key):
        return key%self.hashsize
    
    def hash2(self,key):
        return key//self.bucketsize
    
    def put(self, key: int, value: int) -> None:
        hv1 = self.hash1(key)
        hv2 = self.hash2(key)
        if self.hashmap[hv1] == None:
            self.hashmap[hv1] = [None] * self.bucketsize
            self.hashmap[hv1][hv2] = value
        else:
            self.hashmap[hv1][hv2] = value

    def get(self, key: int) -> int:
        hv1 = self.hash1(key)
        hv2 = self.hash2(key)
        if self.hashmap[hv1] == None:
            return -1
        else:
            if self.hashmap[hv1][hv2] == None:
                return -1
            else:
                return self.hashmap[hv1][hv2]

    def remove(self, key: int) -> None:
        hv1 = self.hash1(key)
        hv2 = self.hash2(key)
        if self.hashmap[hv1] != None:
            self.hashmap[hv1][hv2] = None  


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,1)
obj.put(2,2)
obj.put(1,3)
param_2 = obj.get(1)
print(param_2)
obj.remove(1)
param_2 = obj.get(2)
print(param_2)