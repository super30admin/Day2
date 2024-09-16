# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Y
# Any problem you faced while coding this : N


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        self.list = [None for _ in range(1000)]

    def buckets(self, key):
        return (key % 1000, key // 1000)

    def add(self, key: int) -> None:
        bucket, bucketItem = self.buckets(key)
        # assign 1001 to first bucket if not initialized previously
        if self.list[bucket] is None: self.list[bucket] = [False] * 1001 if bucket == 0 else [False] * 1000
        self.list[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket, bucketItem = self.buckets(key)
        if self.list[bucket] is None: return
        self.list[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket, bucketItem = self.buckets(key)
        # return value if bucket contains array, else false
        return self.list[bucket][bucketItem] if self.list[bucket] is not None else False



if __name__ == '__main__':

    myHashSet = MyHashSet()
    myHashSet.add(1000000)
    myHashSet.contains(1000000)
