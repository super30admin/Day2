# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
#

class MyHashSet:
    def __init__(self):
        self.bucketlength = 1000
        self.bucket = [None] * self.bucketlength

    def hashkey(self, key):
        return key % self.bucketlength

    def doublehash(self, key):
        return key // self.bucketlength

    def add(self, key):
        hi = self.hashkey(key)
        dhi = self.doublehash(key)
        # edge case. if the element is 10,00,000 so the primary hashing key is 0 and secondary hashing index = 1000
        # which is out of range so for 0th index (for 10,00,000) we create a bucket with length 1001
        if not self.bucket[hi] and hi == 0:
            self.bucket[hi] = [False] * (self.bucketlength + 1)
        elif not self.bucket[hi]:
            self.bucket[hi] = [False] * self.bucketlength
        self.bucket[hi][dhi] = True

    def remove(self, key):
        hi = self.hashkey(key)
        dhi = self.doublehash(key)
        if self.bucket[hi]:
            self.bucket[hi][dhi] = False

    def contains(self, key):
        hi = self.hashkey(key)
        dhi = self.doublehash(key)
        if self.bucket[hi]:
            return self.bucket[hi][dhi]


# Your MyHashSet object will be instantiated and called as such:
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
#         self.hashsetlength = 199
#         self.hashset = [[]] * self.hashsetlength
#
#     def hashkey(self, key):
#         return key % self.hashsetlength
#
#     def add(self, key: int) -> None:
#         index = self.hashkey(key)
#         if not self.hashset[index]:
#             self.hashset[index] = [key]
#         else:
#             self.hashset[index].append(key)
#
#     def remove(self, key: int) -> None:
#         index = self.hashkey(key)
#         if key in self.hashset[index]:
#             while key in self.hashset[index]:
#                 self.hashset[index].remove(key)
#
#     def contains(self, key: int) -> bool:
#         index = self.hashkey(key)
#         return key in self.hashset[index]

