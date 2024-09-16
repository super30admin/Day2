'''
Time Complexity: O(1), contains, add, remove
Space Complexity: O(n)
Successful leetcode submission
No problems faced
'''


class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.hashset = [None] * self.buckets

    def primaryhashfunc(self, key):
        return key % self.buckets

    def secondaryhashfunc(self, key):
        return key // self.buckets

    def add(self, key: int) -> None:
        primIndex = self.primaryhashfunc(key)
        nestedIndex = self.secondaryhashfunc(key)

        # to handle the edeg case of 1,000,0000 as it will be mapped to 0th primary index
        # So if the primary index is zero and the hashset hasn't been initialized then we
        # create one more nested index to store our 1000th value
        if not self.hashset[primIndex] and primIndex == 0:
            self.hashset[primIndex] = [False] * (self.buckets + 1)

        # if the primary index is not 0 then we don't need to worry about the edge case
        elif not self.hashset[primIndex]:
            self.hashset[primIndex] = [False] * (self.buckets)

        # We use a boolean array which is by default False thus making in True indicates
        # that the number is present in the arrat at that location
        self.hashset[primIndex][nestedIndex] = True

    def remove(self, key: int) -> None:
        primIndex = self.primaryhashfunc(key)
        nestedIndex = self.secondaryhashfunc(key)
        if self.hashset[primIndex]:
            # we just make the position false as only true indicates that the number is                   # present
            self.hashset[primIndex][nestedIndex] = False

    def contains(self, key: int) -> bool:
        primIndex = self.primaryhashfunc(key)
        nestedIndex = self.secondaryhashfunc(key)
        if self.hashset[primIndex]:
            return self.hashset[primIndex][nestedIndex]