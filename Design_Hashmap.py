#Implemented a hashmap using a list of size 10^6
#where key value pair will be stored as the index and the value at the that
#index and the array will have a default value of -1

class MyHashMap:

    def __init__(self):
        self.hashmap = [-1] * 1000001
        
    def put(self, key: int, value: int) -> None:
        self.hashmap[key] = value
        
    def get(self, key: int) -> int:
        return self.hashmap[key]
        
    def remove(self, key: int) -> None:
        self.hashmap[key] = -1
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)