#implement hashmap
#space complexity: O(N)
#time complexity:O(1)

class MyHashMap:

    def __init__(self):
        self.size = 1000001
        self.data = [None]*self.size
        

    def put(self, key: int, value: int) -> None:
        self.data[key]=value
        

    def get(self, key: int) -> int:
        val = self.data[key]
        return val if val!=None else -1

    def remove(self, key: int) -> None:
        self.data[key]=None

