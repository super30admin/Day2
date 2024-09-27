'''
T.C: O(1) - add, remove, contains
S.C: O(N)
'''

class MyHashSet:

    def __init__(self):
        self.bucket_length = 1000
        self.item_length = 1000
        self.bucket = [[] for bucket in range(self.bucket_length)]
        
    def add(self, key: int) -> None:
        bucket = key % self.bucket_length
        item = key // self.item_length
        
        if not self.bucket[bucket]:
            self.bucket[bucket] = [-1 for bucket in range(self.item_length)]
        if bucket == 0:
            self.bucket[bucket].append(-1)
            
        self.bucket[bucket][item] = 1

    def remove(self, key: int) -> None:
        bucket = key % self.bucket_length
        item = key // self.item_length
        
        if not self.bucket[bucket]:
            return -1
        self.bucket[bucket][item] = -1

    def contains(self, key: int) -> bool:
        bucket = key % self.bucket_length
        item = key // self.item_length
        if not self.bucket[bucket]:
            return False
        return self.bucket[bucket][item] != -1
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)