// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially, used divide '/' operator and got a float index. Had to use '//' for int index.

// Your code here along with comments explaining your approach - 
1. Initialize the bucket size, bucketItem and define an empty hashset with size equal to bucket size.
2. Define 2 hashing functions for the primary(main list) and secondary nodes(subsidiary list).
3. In each of the functions, use hashing function to find the indices.
4. For add, if a primary node is not initialized with an empty list of size bucketItem, do the same. Thereafter, set the value at 
secondary node to True.
5. For remove, check if a primary node exists at the point and set the value at secondary node to True.
6. For contains, check if a primary node exists annd if the value at secondary node is True.
	
 class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        Using 'PRIME NUMBER' may be better
        """
        self.bucket = 1000 
        self.bucketItem = 1000
        self.hashset = [None]*self.bucket
    
    def hashIndex1(self, key: int) -> int:
        return key % self.bucket
    
    def hashIndex2(self, key: int) -> int:
        return key // self.bucketItem   
        
    def add(self, key: int) -> None:
        index1 = self.hashIndex1(key)
        index2 = self.hashIndex2(key)
        
        if not self.hashset[index1]:
            self.hashset[index1] = [None]*self.bucketItem
        
        self.hashset[index1][index2] = True
        

    def remove(self, key: int) -> None:
        index1 = self.hashIndex1(key)
        index2 = self.hashIndex2(key)
        if self.hashset[index1]:
            self.hashset[index1][index2] = False
            
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index1 = self.hashIndex1(key)
        index2 = self.hashIndex2(key)
        
        return self.hashset[index1] and self.hashset[index1][index2]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
