#Time complexity: O(n) -> Since the remove operation can take to traverse whole set so it might take o(1) complexity.
#Space complexity: Here the space allocation is O(1) since we allocate new set here. 
#Approach: The approach is pretty simple where we implement a set to put, get or remove a element in the set. 
class MyHashMap:

    def __init__(self):
        self.myHm = {}
        

    def put(self, key: int, value: int) -> None:
        self.myHm[key] = value

    def get(self, key: int) -> int:
        return self.myHm[key] if key in self.myHm  else -1
       

    def remove(self, key: int) -> None:
        if key in self.myHm:
            del self.myHm[key]
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)