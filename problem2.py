# Time Complexity : O(1)
# Space Complexity : O(k^2) where k is size of hash table choosen. Here 1000. 
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this : No
class MyHashMap:

    def __init__(self):
        self.hash_set = [None] * 1000
        

    def put(self, key: int, value: int) -> None:
        first_key = key % 1000
        second_key = key // 1000
        if self.hash_set[first_key] == None:
            self.hash_set[first_key] = [None] * 1001
        self.hash_set[first_key][second_key] = value
        

    def get(self, key: int) -> int:
        first_key = key % 1000
        second_key = key // 1000
        if self.hash_set[first_key] != None:
            if self.hash_set[first_key][second_key] != None:
                return self.hash_set[first_key][second_key]
        return -1
        

    def remove(self, key: int) -> None:
        first_key = key % 1000
        second_key = key // 1000
        if self.hash_set[first_key] != None:
            if self.hash_set[first_key][second_key] != None:
                self.hash_set[first_key][second_key] = None
                

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
