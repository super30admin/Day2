# Time Complexity :- contains O(1) for put , O(N+1) get , O(N+1) remove
# # Space Complexity : - O(2N) where N is the number of elements and 2N is because we are using 2 arrays 
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : Yes the code did run on leetcode but the performance is not that better thought of alternate solution but still not that good performance


class MyHashMap:

    def __init__(self):
        self.hashKey = []
        self.hashValue = []

    def put(self, key: int, value: int) -> None:
        if key in self.hashKey:
            indexOfKey = self.hashKey.index(key)
            self.hashValue[indexOfKey] = value
        else:
            self.hashKey.append(key)
            self.hashValue.append(value)

    def get(self, key: int) -> int:
        if key in self.hashKey:
            indexOfKey = self.hashKey.index(key)
            return self.hashValue[indexOfKey]
        else:
            return -1
        

    def remove(self, key: int) -> None:
        if key in self.hashKey:
            indexOfKey = self.hashKey.index(key)
            del self.hashKey[indexOfKey]
            del self.hashValue[indexOfKey]
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)


## Another approach

# class MyHashMap:

# 			def __init__(self):
# 				self.hash_table = {}

# 			def put(self, key: int, value: int) -> None:
# 				self.hash_table[key] = value

# 			def get(self, key: int) -> int:
# 				if key in self.hash_table.keys():
# 					return self.hash_table[key]
# 				else:
# 					return -1

# 			def remove(self, key: int) -> None:
# 				if key in self.hash_table.keys():
# 					self.hash_table.pop(key)