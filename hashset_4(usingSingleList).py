# time complexity for operations is O(1) but the space required is too high.

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000000 # initializing 1 million records array
        self.storage = [None for i in range(self.buckets)] #initializing a list

    def bucketsHash(self, value):
        return value % self.buckets # developing a hash function

    def add(self, value: int) -> None:
        buc = self.bucketsHash(value) # getting hash value
        # print(buc,bucItem)
        # if self.storage[buc] is None:
        self.storage[buc] = True # inserting true for the data if exists
        # print(self.storage[buc][bucItem])

    def remove(self, value: int) -> None:
        buc = self.bucketsHash(value) # getting hash value
        if self.storage[buc] is not None:
            self.storage[buc] = False # if the value is present remove it by making false

    def contains(self, value: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        buc = self.bucketsHash(value) # getting hash value
        if self.storage[buc] == True:
            return True # if the value is present return true.
