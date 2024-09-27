#time complexity O(n)
#space complexity O(N)
class MyHashMap:

    def __init__(self):
        self.list = [-1]*10000001  #initialiaze a list and mark all the index pos to -1
        

    def put(self, key: int, value: int) -> None:
        self.list[key] = value     # at the index key insert the value
        

    def get(self, key: int) -> int:
        return self.list[key]      # return the value at the key index
        

    def remove(self, key: int) -> None:
        self.list[key] =-1         # update the key index to -1 to remove the value
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)