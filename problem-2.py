#Time Complexity: O(n)
#Space Complexity: O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class MyHashSet:
#Initialize hashtable 
    def __init__(self):
        self.size = 10000
        self.hashTable = [None]*self.size
#Function to hash   
    def hashing(self, key):
        return key%self.size

    def add(self, key: int) -> None:
        hashkey = self.hashing(key)
#If entry doesn't exist at the index in table, enter first element at the index or append at the index
        if self.hashTable[hashkey] == None:
            self.hashTable[hashkey] = [key]
        else:
            self.hashTable[hashkey].append(key)
        

    def remove(self, key: int) -> None:
        hashkey = self.hashing(key)
#Search is index is not empty
        if self.hashTable[hashkey] != None:
#Remove all instances of key from the hashset
            while key in self.hashTable[hashkey]:
                self.hashTable[hashkey].remove(key)
        

    def contains(self, key: int) -> bool:
        hashkey  = self.hashing(key)
#if key is present, return index
        if self.hashTable[hashkey]!=None:
            return key in self.hashTable[hashkey]
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)