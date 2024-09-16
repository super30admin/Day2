# Time complexity: O(1) best/average case, O(n) worst case(if the chain for a hash value is very large)
# Space complexity: O(n)
# Did this code run on leetcode: yes
# Any problem you faced while coding this : By default I was inclined to using the built in set() in python to solve this. Then I tried creating a boolean list to hold true/false for each item being added/removed.
# Later I stumbled upon creating a decent hash function.

'''
Implementation involves using list of lists as storage buckets to perform chaining on the keys to resolve collission.
Generate a hash for the given key(item) and then store the key(item) in that index of the hash.
The hash function used here is a simple one => a modulus on the length of the list. While this is good hash function for this use case, it might not be great if the elements end up getting the hash value. A better hash function could be using an unusual prime number as the mod value
'''


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # use a large number for the keys - given that the max number of add/remove/contains operations that will occur for this hashset is 10^4, it is safe to consider 10^4+1 as the bucket length
        self.numBuckets = 10001
        self.buckets = [[] for i in range(self.numBuckets)]

    def generateHashKey(self, key):
        return key % self.numBuckets

    def add(self, key: int) -> None:
        hashkey = self.generateHashKey(key)
        if key not in self.buckets[hashkey]:
            self.buckets[hashkey].append(key)

    def remove(self, key: int) -> None:
        hashkey = self.generateHashKey(key)
        if key in self.buckets[hashkey]:
            self.buckets[hashkey].remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashkey = self.generateHashKey(key)
        if key in self.buckets[hashkey]:
            return True
        return False


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(5)
obj.remove(1)
print(obj.contains(5))
