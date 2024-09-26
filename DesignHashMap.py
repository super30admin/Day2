# Time Complexity : O(1)
# Space Complexity : Worst Case: Max Value , O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class MyHashMap:
    '''
    Clarify:
    Do we have an expected data range, min and max, for our key and value?
    Do we have an expected number of calls that this system is going to have to handle?
    
    I will use a simplified version of multiplicative hashing with bucketing as arrays.
    Why?
    I want to optimise for speed since the basic utility of hashmap is O(1) Retrieval 
    '''
    def __init__(self):
        self.k = (10 ** 3)
        self.hashMap = [-1] * self.k
        
    def getKeys(self, key):
        key1 = key % self.k
        key2 = key // self.k
        return [key1, key2]
        
    def put(self, key: int, value: int) -> None:
        
        key1, key2 = self.getKeys(key)
        if self.hashMap[key1] == -1:
            if key1 == 0:
                self.hashMap[key1] = [-1] * (self.k + 1)
            else:
                self.hashMap[key1] = [-1] * (self.k)
        
        self.hashMap[key1][key2] = value

    def get(self, key: int) -> int:
        key1, key2 = self.getKeys(key)
        if self.hashMap[key1] != -1:
            return self.hashMap[key1][key2]
        
        return -1
        

    def remove(self, key: int) -> None:
        key1, key2 = self.getKeys(key)
        if self.hashMap[key1] != -1:
                self.hashMap[key1][key2] = -1
        
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)