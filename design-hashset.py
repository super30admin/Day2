  
# Time Complexity : O(1) for all the three operations
# Space Complexity : O(n^2), may be, as we have an array of arrays, not sure
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Approach:
#1. We will take an array of arrays, with size = sqrt(our range), we will use hashing to store the elements of hashset in our array.
#2. As we receive two elements with same hash for the array, we will use another hashing algorithm to store the element in our sub array. (like H = key%1000 for 
# main array and H2 = key/1000 for sub array
#3. Now, as we have an array of arrays with hashes for every index in this 2-D array, we know that which element will go where, so instead of storing the element 
# itself, we can just store a boolean or a flag at the index like a True or False, which indicates that whether the element is there in the HashSet or not.

class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketItems = 1000
        self.bucketList = [False for i in range(1000)]
        self.bucketArr = [self.bucketList[:] for i in range(1000)]
    
    def getBucket(self, key):
        return key%self.buckets
    
    def getBucketItem(self, key):
        return key/self.bucketItems

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        self.bucketArr[bucket][bucketItem] = True
        
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        self.bucketArr[bucket][bucketItem] = False

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        return self.bucketArr[bucket][bucketItem] == True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
