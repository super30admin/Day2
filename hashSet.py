"""
Intuition: In this program, a hashset is implemented to store keys.

A 2D array has been created to indicate wheather a key is present or not. 
The key is located by computing its hashValue.
If 2 keys have the same hashValue, collision occurs and then we compute another hashvalue to store the key.

Another way to visulize it is:
The 'row' or the 'ith' index of the key is obtainted by getting computing: key % perfectSquare(numberOfElements)
The 'column' or the 'jth' index of the key is obtainted by getting computing: key / perfectSquare(numberOfElements)

#####################################################################
Add Method: Inserting a value at a key if the key is present. The value will be overwritten if the key is not present.
Time Complexity : O(1)
Space Complexity : O(perfectSquare(N)) if collision occurs, where N = perfectSquare(numberOfElements)
Space Complexity : O(1) if collision has already occured and array is already created.
#####################################################################
Remove Method: Accessing the value at a particular key.
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
Contains Method: The key is removed only if it is present.
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
getHashValueForPrimaryArray Method: Computes the hashValue for the primary array
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
getHashValueForSecondaryArray Method: Computes the hashValue for the secondary array
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
Total Space Complexity: O(N) where N = 10^6 for the number of keys/calls
"""
class MyHashSet:

    def __init__(self):
        #Instead of storing the keys, a true or false values could be stored to check if a key is preesnt or not
        self.hashSet = [False]  * 1000
        
    def getHashValueForPrimaryArray(self,key):
        return key % 1000

    def getHashValueForSecondaryArray(self,key):
        return key // 1000      
        
    def add(self, key: int) -> None:
        
        hashValue = self.getHashValueForPrimaryArray(key)
        secondaryHashValue = self.getHashValueForSecondaryArray(key)

        #Checks if a key is not present in the primary array
        if self.hashSet[hashValue] == False:

            #handles the case of key = 10^6 
            if hashValue == 0:
                self.hashSet[hashValue] = [False] * 1001
            else:
                self.hashSet[hashValue] = [False] * 1000
        self.hashSet[hashValue][secondaryHashValue] = True
        
    def remove(self, key: int) -> None:
        
        hashValue = self.getHashValueForPrimaryArray(key)
        secondaryHashValue = self.getHashValueForSecondaryArray(key)

        #If the hashset at hashvalue is false, no key is present. 
        if self.hashSet[hashValue] == False:
            return
        
        self.hashSet[hashValue][secondaryHashValue] = False

    def contains(self, key: int) -> bool:
        hashValue = self.getHashValueForPrimaryArray(key)
        secondaryHashValue = self.getHashValueForSecondaryArray(key)
        
        #If the hashset at hashvalue is false, no key is present.
        if self.hashSet[hashValue] == False:
            return False
        
        return self.hashSet[hashValue][secondaryHashValue]
        
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)