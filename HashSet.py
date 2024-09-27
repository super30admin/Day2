# Time Complexity : O(1)
# Space Complexity : Worst Case, O(self.bucketNum * self.bucketNum)
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class MyHashSet(object):

    def __init__(self):
        # matrix dimensions
        self.bucketNum = 1000
        # matrix initial array init
        self.bucketArray = [False] * self.bucketNum

    def bucketIndexHashing(self, key):
        # Identity hashing function.
        return key % self.bucketNum

    def nestedBucketIndexHashing(self, key):
        # Double hashing function, Division.
        return key / self.bucketNum

    def add(self, key):
        # Computing both hash values
        bucketIdx = self.bucketIndexHashing(key)
        nestedBucketIdx = self.nestedBucketIndexHashing(key)
        # Nested Array init if not initialised.
        if self.bucketArray[bucketIdx] == False:
            self.bucketArray[bucketIdx] = [False] * self.bucketNum
        # marking value true i.e. value present in hashSet
        self.bucketArray[bucketIdx][nestedBucketIdx] = True

    def remove(self, key):
        # Computing both hash values
        bucketIdx = self.bucketIndexHashing(key)
        nestedBucketIdx = self.nestedBucketIndexHashing(key)
        # If array initialised changing value to false
        if self.bucketArray[bucketIdx]:
            self.bucketArray[bucketIdx][nestedBucketIdx] = False

    def contains(self, key):
        # Computing both hash values
        bucketIdx = self.bucketIndexHashing(key)
        nestedBucketIdx = self.nestedBucketIndexHashing(key)
        # returning Boolean if array initialised and value present or not
        return self.bucketArray[bucketIdx] and self.bucketArray[bucketIdx][nestedBucketIdx]


# Your MyHashSet object will be instantiated and called as such:
hashSet = MyHashSet()
hashSet.add(6)
hashSet.remove(4)
hashSet.remove(6)
hashSet.add(17)
print hashSet.bucketArray
print hashSet.contains(14)
hashSet.add(14)
hashSet.remove(17)
hashSet.add(14)
hashSet.add(14)
hashSet.add(18)
hashSet.add(14)
