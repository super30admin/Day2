# Time Complexity : O(1) for all operations
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


#Your code here along with comments explaining your approach
class MyHashSet:

    def __init__(self):
        self.buckets=1000
        self.bucketItems=1001
        self.container=[False]*self.buckets
    
    def getBucket(self,key):
        return key%self.buckets

    def getBucketItem(self, key: int) -> None:
        return key//self.buckets
    
    def add(self, key: int) -> None:
        bucket=self.getBucket(key)
        bucketItem=self.getBucketItem(key)
        if not self.container[bucket]:
            self.container[bucket]=[False]*self.bucketItems
        print(key,bucket,bucketItem)
        self.container[bucket][bucketItem]=True

    def remove(self, key: int) -> None:
        bucket=self.getBucket(key)
        bucketItem=self.getBucketItem(key)
        if self.container[bucket]:
            self.container[bucket][bucketItem]=False

    def contains(self, key: int) -> bool:
        bucket=self.getBucket(key)
        bucketItem=self.getBucketItem(key)
        return self.container[bucket] and self.container[bucket][bucketItem]!=False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)