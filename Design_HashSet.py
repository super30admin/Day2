class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucket_items = 1000
        self.map = [[False]*(self.bucket_items+1) for _ in range(self.buckets)]
        
    def __doubleHash(self, key):
        bucket = key % self.buckets
        bucket_item = key // self.bucket_items
        return(bucket, bucket_item)

    def add(self, key: int) -> None:
        bucket, bucket_item = self.__doubleHash(key)
        self.map[bucket][bucket_item] = True

    def remove(self, key: int) -> None:
        bucket, bucket_item = self.__doubleHash(key)
        self.map[bucket][bucket_item] = False        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket, bucket_item = self.__doubleHash(key)
        return self.map[bucket][bucket_item]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)