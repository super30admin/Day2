# As per the class I tried double hashing technique for hashset, in leetcode failed 4 testcases. Not sure.
# My challenges were Initializing lists with boolean variables, and accessing public variables where i was stuck.
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000 # list of 1000 items
        self.bucketItems = 1000 # list of 1000 items
        self.storage = [None for i in range(self.buckets)] # initializing list variables as None at beginning

    def bucketsHash(self, value):
        return value % self.buckets #return hash code

    def bucketItemsHash(self, value):
        return value % self.bucketItems # return hashcode

    def add(self, value: int) -> None:
        buc = self.bucketsHash(value) # get the hashcode for main list
        bucItem = self.bucketItemsHash(value) # get the hash code for sublist
        # print(buc,bucItem)
        if self.storage[buc] is None:
            self.storage[buc] = [None for i in range(self.bucketItems)] # if main list is none initialize sublist
        if self.storage[buc] is not None and self.storage[buc][bucItem] is None:
            # if main list is initialized and having a sublist and sublist hash item
            # is None then initialize it to True which adds an item.
            self.storage[buc][bucItem] = True
        # print(self.storage[buc][bucItem])

    def remove(self, value: int) -> None:
        buc = self.bucketsHash(value) # get the hashcode for main list
        bucItem = self.bucketItemsHash(value) # get the hash code for sublist
        if self.storage[buc] is not None:
            # if mainlist is not none then make the item false
            # to remove the item.
            self.storage[buc][bucItem] = False

    def contains(self, value: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        buc = self.bucketsHash(value) # get the hashcode for main list
        bucItem = self.bucketItemsHash(value) # get the hash code for sublist
        if self.storage[buc] is not None and self.storage[buc][bucItem]:
            # if main list is not none and sublist is true then return true as element is found
            # else return false as the element doesnt exist.
            return True

