
"""
// Time Complexity : O(1) for add(), remove is O(1 + load factor), search O(n)

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
class MyHashSet:
#1 million int, 1000x1000
    def __init__(self):
        self.initialSet = 10
        self.hashTable = [None] * self.initialSet



    def hashFxn(self,key):
        return key % self.initialSet

#use boolean to store numbers
    def add(self, key: int) -> None:
        fxn = self.hashFxn(key)
        if self.hashTable[fxn] == None:
            self.hashTable[fxn] = [key] #create a bucket array, basically 2nd array for 2d
        else:
            fxn = self.hashFxn(key)
            self.hashTable[fxn].append(key)

    def remove(self, key: int) -> None:
        fxn = self.hashFxn(key)
        if self.hashTable[fxn] != None:
            while key in self.hashTable[fxn]:
                self.hashTable[fxn].remove(key)



    def contains(self, key: int) -> bool:
        fxn = self.hashFxn(key)
        if self.hashTable[fxn] != None:
            return key in self.hashTable[fxn]
        return False

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(6)
obj.add(7)
obj.add(7)
obj.add(7)
obj.add(9)
obj.add(8)
obj.remove(7)
param_3 = obj.contains(6)
print(param_3)
print(obj.hashTable)