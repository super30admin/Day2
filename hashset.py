# Time complexity: hash() - O(1), pos() - O(1) , add() - O(1) , remove() - O(1), contains() - O(1)
# Space complexity: O(n^2) due to having secondary hashmaps
# Running on leetcode: yes
# class to implement hashset
class MyHashSet(object):
    # initializing the hashset data structure
    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1000
        self.data = [None]*self.buckets
    # function to get the hash
    def hash(self,key):
        return key%self.buckets
    # function to get the secondary hash
    def pos(self,key):
        return key//self.bucketitems
    #function to add new key to the hashset
    def add(self, key):
        bucket = self.hash(key)
        if not self.data[bucket]:
            self.data[bucket] = [None]*self.bucketitems
        self.data[bucket][self.pos(key)]= True
        
    #function to remove a key from the hashset
    def remove(self, key):
        bucket = self.hash(key)
        if self.data[bucket]:
            self.data[bucket][self.pos(key)] = False
        
    #function to check if the key is in the data structure 
    def contains(self, key):
        bucket = key%self.buckets
        return ( self.data[bucket] is not None) and self.data[bucket][self.pos(key)]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)