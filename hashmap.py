# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
# I have used normal modulus for this method
class MyHashMap(object):

    def __init__(self):
        self.size = 1000000
        self.arr = [-1]*self.size
        

    def put(self, key, value):
        hashkey = key % self.size
        self.arr[hashkey] = value
        

    def get(self, key):
        hashkey = key % self.size
        if hashkey < 0 or hashkey >= self.size:
            return -1
        return self.arr[hashkey]
      

    def remove(self, key):
        hashkey = key % self.size
        self.arr[hashkey] = -1