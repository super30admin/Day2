#Time Complexity : O(1) for all methods
#Space Complexity : O(n + log(n) )
#Did this code successfully run on Leetcode : Yes
class MyHashSet:

    def __init__(self):
        #creating primary array. Secomdary array will be created only when it is required to save space.
        self.bucket = 1000
        self.bucket_items = 1000
        self.storage = [None] * self.bucket

    def hash_1(self, key) -> int:
        #hash function 1
        return key % self.bucket

    def hash_2(self, key) -> int:
        #hash function 2
        return key // self.bucket_items

    def add(self, key: int) -> None:
        #for addition, we we will sotre it in such a way that value = index in nested array.
        # secondary array is created as per as requirement of size mentioned above.
        bucket = int(self.hash_1(key))
        bucket_items = int(self.hash_2(key))
        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [None] * (self.bucket_items + 1)
                # +1 is done here because of we get value(after double hashing) = 1000
                # but we only have from 0 till 999. So just for index=0(edge case), we insert one more
                #array space.
                # self.storage.insert(bucket, [None] * (self.bucket_items+1) )
            else:
                self.storage[bucket] = [None] * (self.bucket_items)
                # self.storage.insert(bucket, [None] * self.bucket_items )
        self.storage[bucket][bucket_items] = True
        #we are using boolean way, so we till make None = True

    def remove(self, key: int) -> None:
        #Since we =are usoing boolean, we just make True = False
        bucket = self.hash_1(key)
        bucket_items = self.hash_2(key)
        if self.storage[bucket] == None:
            return

        self.storage[bucket][bucket_items] = False

    def contains(self, key: int) -> bool:
        #value after double hashing is index in nested array so, we are directly fetching in O(1).
        bucket = self.hash_1(key)
        bucket_items = self.hash_2(key)

        if self.storage[bucket] == None:
            return False

        print("key = ", key)
        print("Contains : ", self.storage[bucket][bucket_items])
        return self.storage[bucket][bucket_items] == True

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
