# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.key_space = 1024
        self.grid_space = 1024
        self.hash_map = [[]]*self.key_space
    
    def get_hash(self,key):
        return key % self.key_space
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash_key = self.get_hash(key)
        grid_key = key // self.grid_space
        
#         Dynamically creating grid spaces
        if len(self.hash_map[hash_key]) == 0:
            self.hash_map[hash_key] = [-1 for _ in range(self.grid_space)] 
        
        self.hash_map[hash_key][grid_key] = value
        
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_key = self.get_hash(key)
        grid_key = key // self.grid_space
        if len(self.hash_map[hash_key]):
            return self.hash_map[hash_key][grid_key]
        else:
            return -1
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hash_key = self.get_hash(key)
        grid_key = key // self.grid_space
        if len(self.hash_map[hash_key]):
             self.hash_map[hash_key][grid_key] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
