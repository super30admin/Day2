"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket = [[]]*1001

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        indice = key % 1001
        for index, val in enumerate(self.bucket[indice]):
            if val[0] == key:
                val[1] = value
                return
        self.bucket[indice].append([key, value])
        
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        indice = key % 1001
        for index, val in enumerate(self.bucket[indice]):
            if val[0] == key:
                return val[1]
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        indice = key % 1001
        if self.bucket[indice]:
            for index, val in enumerate(self.bucket[indice]):
                if val[0] == key:
                    del self.bucket[indice][index]
                    return
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)