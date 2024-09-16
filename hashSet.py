# Hash Set does not allow presence of duplicate keys, so when the collision occurs it has to be handled precisely. As designed a hashmap earlier, I used chaining.
# The difference here will be there are no duplicates allowed.
# This approach can be modified to using double hashing as taught in class.
# Time Complexity: add - O(1), remove - O(n), contains - O(n) 
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashList = [[] for i in range(10)]

    def getHashKey(self,key):
        if (str(key).isdigit()):
            return len(self.hashList)%key
        else:
            sumKey = 0
            for character in key:
                sumKey = sumKey + ord(character)
            return sumKey%len(self.hashList)
    
    def getList(self,key):
        return self.hashList[key]

    def add(self, key: int) -> None:
        insertKey = self.getHashKey(key)
        print("Inserting into the data structure")
        keyList = self.getList(insertKey)
        if (len(keyList)==0):
            self.hashList[insertKey].append(key)
        else:
            print("Key already present, cannot re-enter the key")
        print(self.hashList)

    def remove(self, key: int) -> None:
        removeKey = self.getHashKey(key)
        keyList = self.getList(removeKey)
        if (key in keyList):
            keyList.remove(key)
        else:
            print("Cannot remove the element as it does not exist")

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        containsKey = self.getHashKey(key)
        keyList = self.getList(containsKey)
        if (key in keyList):
            return True
        else:
            return False


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(3)
obj.contains(2)
obj.remove(2)
param_3 = obj.contains(1)
print("Elements exists: ",param_3)