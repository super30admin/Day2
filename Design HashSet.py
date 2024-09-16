""""// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Getting optimized method


// Your code here along with comments explaining your approach"""


class MyHashSet:
    def __init__(self):
        self.size = 1000
        self.hash = [None for i in range(self.size)]

    def hashfunc(self, key):
        return key % self.size

    def hashitm(self, key):
        return key // self.size

    def add(self, key: int) -> None:
        bucket = self.hashfunc(key)

        # If array is not present at a bucket, create a new array of size 1000(1001 if bucket is 0)
        if (self.hash[bucket] == None):
            if bucket == 0:
                self.hash[bucket] = [None] * 1001
            else:
                self.hash[bucket] = [None] * 1000

        # get the index where to place value
        bitem = self.hashitm(key)
        self.hash[bucket][bitem] = key

    def remove(self, key: int) -> None:
        # If bucket exists remove value from array
        if self.hash[self.hashfunc(key)] != None:
            self.hash[self.hashfunc(key)][self.hashitm(key)] = None

    def contains(self, key: int) -> bool:
        if self.hash[self.hashfunc(key)] != None:
            return self.hash[self.hashfunc(key)][self.hashitm(key)]
            return None
obj = MyHashSet()
obj.add(1)
obj.add(2)
print(obj.contains(1))
print(obj.contains(3))
obj.add(2)
print(obj.contains(2))
obj.remove(2)
print(obj.contains(2))


# class MyHashSet:
#     def __init__(self):
#         self.buckets=1000
#         self.bucketItem=1000
#         self.storage=[None for i in range(self.buckets)]
#     def hash1(self,val):
#         return val%self.buckets
#     def hash2(self,val):
#         return val//self.bucketItem
#     def add(self, key: int) -> None:
#         bucket=self.hash1(key)
#         bi=self.hash2(key)
#         if self.storage[bucket]==None:
#             if bucket==0:
#                 self.storage[bucket]=[False for i in range(self.bucketItem+1)]
#             else:
#                 self.storage[bucket]=[False for i in range(self.bucketItem)]
#         self.storage[bucket][bi]==True
#         print(self.storage[bucket][bi])
#     def remove(self, key: int) -> None:
#         bucket= self.hash1(key)
#         bi=self.hash2(key)
#         if self.storage[bucket]==None:
#             pass
#         else:
#             self.storage[bucket][bi]=False
#     def contains(self, key: int) -> bool:
#         bucket= self.hash1(key)
#         bi=self.hash2(key)
#         if self.storage[bucket]==None:
#             return False
#         else:
#             return self.storage[bucket][bi]