# Time Complexity : O(N/K) here and N is the number of values; K=10000 
# Space Complexity : O(K+M) here K =10000 and M is no.of unique values
# Did this code successfully run on Leetcode : Yes, with Runtime: 180 ms and Memory Usage: 19.4 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach : 
# Using Seperate Chaining approach The hash value/index is calculated using
# key%bucket number and the elements are added, removed and searched. 

class MyHashSet(object):
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket_num=10000
        self.data=[[] for i in range(self.bucket_num)]
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
       """
        hash_value=key%self.bucket_num
        if key not in self.data[hash_value]:
            return self.data[hash_value].append(key)
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash_value=key%self.bucket_num
        if key in self.data[hash_value]:
                return self.data[hash_value].remove(key)

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        hash_value=key%self.bucket_num
        if key in self.data[hash_value]:
                return self.data[hash_value]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)