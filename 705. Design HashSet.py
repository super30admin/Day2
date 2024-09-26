# Time Complexity : O(1)
# Space Complexity : O(n)

# // Did this code successfully run on Leetcode : Yes,it did run
# // Any problem you faced while coding this : I was strugglinkg in intializing the 
#  a booloean array in python but then realied it can be done easily


# Your code here along with comments explaining your approach
# Create a primary array of size 1000 bcoz sqrt(1000000) with None in it
#  Hash fn: 1 key % 1000 and  2 key // 1000
#  For each operation run both the hash first
# # ADD : While adding check if the cell is None
#             If So create secondary array at that location with size 1000
#             else the array might have been already created preiously so 
#             just add the new element at the index given by the has fn
# # Remove: Check if the primary array value is None -> Yes return
#           else go to its nested index and make the element to False
# # contains: Check if the primary array value is None -> Yes return
#             else go to its nested index and return it
            
class MyHashSet:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketitems = 1000
        
        self.array = [None] * self.buckets
        

    def bucketIndex(self,key):
        return key % self.buckets
    
    def bucketitemIndex(self,key):
        return key // self.bucketitems
    
    def add(self, key: int) -> None:
        bucket = self.bucketIndex(key)
        bucketitem = self.bucketitemIndex(key)
    
        if self.array[bucket] == None :
            self.array[bucket] =  [None] * self.bucketitems
        self.array[bucket][bucketitem] =  True

    def remove(self, key: int) -> None:
        bucket = self.bucketIndex(key)
        bucketitem = self.bucketitemIndex(key)
        
        if self.array[bucket] == None:
            return
        self.array[bucket][bucketitem] =  False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = self.bucketIndex(key)
        bucketitem = self.bucketitemIndex(key)
        if self.array[bucket] == None:
            return
        return self.array[bucket][bucketitem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)