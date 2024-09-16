#Time Complexity : O(1)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes it did successfully
#Any problem you faced while coding this : Not really

#Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket = [None] * 10000 #making a hashset and repeating it for 10000 times i.e. the length because it is given that at most 10000                                          
                                        # calls will be made to add, remove and contains.
        
    #inserts value in the Hashset
    def add(self, key: int) -> None:
        key_1 = key % 10000 #calculating the hash value
        
        if self.bucket[key_1] == None:
            self.bucket[key_1] = [key] #adding key as a list
        else:
            self.bucket[key_1].append(key)

    #removes the value from the hashset
    def remove(self, key: int) -> None:
        key_1 = key % 10000 #calculating the hash value
        
        if self.bucket[key_1] != None:
            while key in self.bucket[key_1]: #checking if all the repeated values are also removed
                self.bucket[key_1].remove(key)
        
    #checks whether the value exists or not
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        key_1 = key % 10000 #calculating the hash value
        
        if self.bucket[key_1] != None: #check if exists, return key
            return key in self.bucket[key_1]
        else:
            return False #else return false


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)