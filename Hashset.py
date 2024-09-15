'''
- Test cases passed on leetcode
'''
class MyHashSet(object):

    def __init__(self):
       
        self.buckets = 1000
        self.arr = [None for i in range(self.buckets)]
        self.bucketSize = 1001

    def add(self, key):
    # O(1) Time Complexity;O(1) Space Complexity
        bucketIndex = key % self.buckets
        InnerbucketIndex = int(key / self.bucketSize)
        if self.arr[bucketIndex] == None:
            self.arr[bucketIndex] = [False for i in range(self.bucketSize)]
        self.arr[bucketIndex][InnerbucketIndex] = True

    def remove(self, key):
    # O(1) Time Complexity;O(1) Space Complexity
        bucketIndex = key % self.buckets
        InnerbucketIndex = int(key / self.bucketSize)
        if self.arr[bucketIndex] != None:
            self.arr[bucketIndex][InnerbucketIndex] = False

    def contains(self, key):
    # O(1) Time Complexity;O(1) Space Complexity
        bucketIndex = key % self.buckets
        InnerbucketIndex = int(key / self.bucketSize)
        return self.arr[bucketIndex] != None and self.arr[bucketIndex][InnerbucketIndex] == True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
