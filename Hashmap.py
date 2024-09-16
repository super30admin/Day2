# Time Complexity : 232
#  Space Complexity : 17.1
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach
class MyHashMap:
    
    #Define a dictionary
    def __init__(self):
        self.dict ={}

    #Inserted the key value pair in dictionary
    def put(self, key: int, value: int) -> None:
        self.dict[key] = value
    
    #Returned the element if found else returned -1
    def get(self, key: int) -> int:
        if key in self.dict:
            return self.dict[key]
        else:
            return -1
    #With the help of pop() removed element from dict
    def remove(self, key: int) -> None:
        if key in self.dict:
            self.dict.pop(key)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)