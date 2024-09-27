#Reference Video: https://youtu.be/w9JhOKb4tyk
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #Define the size of the array to be sqrt of 10^6 which is the size of key
        self.size = 1000
         #Define the array to be of size sqrt of 10^6 (size of key)
        self.array = [None] * self.size
        
        
    def calculateHash(self, key):
        #calculate the hash value by taking the modulus of the size
        return key % self.size
        
    def add(self, key: int) -> None:
        #calculate hash value
        hash_value = self.calculateHash(key)
        #if the array at the index is empty, just add the key
        if self.array[hash_value] == None:
            self.array[hash_value] = [key]
        #if there is an existing value at the index, append the 
        else:
            self.array[hash_value].append(key) 

    def remove(self, key: int) -> None:
        
        #calculate hash value
        hash_value = self.calculateHash(key)
        print(self.array[hash_value])
        #if the array at index hash_value is not empty
        if self.array[hash_value] != None: 
        #lookup if the key exists and while loop to remove all existances of the key
            while key in self.array[hash_value]:
                self.array[hash_value].remove(key)
        # print( self.array[hash_value])

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        #calculate hash value
        hash_value = self.calculateHash(key)
        if self.array[hash_value] != None: 
            return key in self.array[hash_value]
        #if there is no value at index hash_value of array or 
        #if the key does not exist in the array, return false
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)