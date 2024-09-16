"""
Design a HashMap without using any built-in hash table libraries.

Time Complexity : O(N /K), N = number of possible keys; K = predefined bucket in hashmap (9311)
Space Complexity :O(N + k)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
"""

class Bucket:
    def __init__(self):
        self.bucket = []
        
    def get(self,key):
        for (k,v) in self.bucket:
            if k == key:
                return v
        return -1
    
    def update(self,key,value):
        updated = False
        for i, ele in enumerate(self.bucket):
            if key == ele[0]:
                self.bucket[i] = (key, value)
                updated = True
                break
                
        if not updated:
            self.bucket.append((key,value))
            
    def remove(self,key):
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                del self.bucket[i]
            
        

class MyHashMap:

    def __init__(self):
        self.key_range = 9311
        self.hash_map = [Bucket() for i in range(self.key_range)]
        
    def _hash(self,key):
        return key % self.key_range
        
    def put(self, key: int, value: int) -> None:
        hash_key = self._hash(key)
        self.hash_map[hash_key].update(key,value)
        
        
    def get(self, key: int) -> int:
        hash_key = self._hash(key)
        return self.hash_map[hash_key].get(key)
        

    def remove(self, key: int) -> None:
        hash_key = self._hash(key)
        self.hash_map[hash_key].remove(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)