# // Time Complexity : O(1)
# // Space Complexity : 0(n2)
# // Did this code successfully run on Leetcode : Yes

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset = [None] * 1000

    def get_bucket(self, key) -> int:
        return key % 1000

    def get_bucket_number(self, key) -> int:
        return int(key / 1000)

    def add(self, key: int) -> None:
        bucket = self.get_bucket(key)
        bucket_number = self.get_bucket_number(key)
        if not self.hashset[bucket]:
            if bucket == 0:
                self.hashset[bucket] = [False] * (1001)
            else:
                self.hashset[bucket] = [False] * 1000
        self.hashset[bucket][bucket_number] = True

    def remove(self, key: int) -> None:
        bucket = self.get_bucket(key)
        bucket_number = self.get_bucket_number(key)
        if not self.hashset[bucket]:
            return
        else:
            self.hashset[bucket][bucket_number] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = self.get_bucket(key)
        bucket_number = self.get_bucket_number(key)
        if not self.hashset[bucket]:
            return False
        else:
            return self.hashset[bucket][bucket_number]


# Your MyHashSet object will be instantiated and called as such:
myHashSet = MyHashSet()
myHashSet.add(1000000)  # set = [1]
myHashSet.add(2)  # // set = [1, 2]
print(myHashSet.contains(1))  # // return True
print(myHashSet.contains(3))  # // return False, (not found)
myHashSet.add(2)  # // set = [1, 2]
print(myHashSet.contains(2)) # return True
myHashSet.remove(2)  # // set = [1]
print(myHashSet.contains(2))  # // return False, (already removed)
