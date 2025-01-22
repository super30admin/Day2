# Time Complexity : 
    # put() -> O(1)
    # get() -> O(1)
    # remove() -> O(1)

# Space Complexity : O(N)

# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this Your code here along with comments explaining your approach: NO

# Your code here along with comments explaining your approach

# 1. Standard Double hashing with a primary and secondary array
# 2. Have the secondary array elements initialized to -1 since the given input range is [0, 10^6]

class MyHashMap:

    def __init__(self):
        self.buckets = 1000
        self.bucketsize = 1000
        self.primary_arr = [-1] * self.buckets
    
    def hash1(self, num):
        return num % self.buckets
    
    def hash2(self, num):
        return num // self.bucketsize
        
    def put(self, key: int, value: int) -> None:
        bucket = self.hash1(key)
        if self.primary_arr[bucket] == -1:
            # edge case where the first bucket (index = 0) will have N+1 possible collisions
            if bucket == 0:
                self.primary_arr[bucket] = [-1] * (self.bucketsize + 1)
            else:
                self.primary_arr[bucket] = [-1] * self.bucketsize
            sec_pos = self.hash2(key)
            self.primary_arr[bucket][sec_pos] = value
        else:
            sec_pos = self.hash2(key)
            self.primary_arr[bucket][sec_pos] = value

    def get(self, key: int) -> int:
        bucket = self.hash1(key)
        if self.primary_arr[bucket] == -1:
            return -1
        
        return self.primary_arr[bucket][self.hash2(key)]

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        if self.primary_arr[bucket] == -1:
            return

        sec_pos = self.hash2(key)
        self.primary_arr[bucket][sec_pos] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)