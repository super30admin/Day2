
# ----- Please let me know any suggestions or improvements for me to follow.
#Time Complexity : O(n), for the while function inside the inner list.
#Space Complexity :O(n^2), due to a list being declared, though I am not sure for this.
# This is implemented and accepted on Leetcode.

class MyHashSet:

    def __init__(self):
        self.size = 1000 # taking a size variable
        self.set = [None] * self.size # defining a list for implementing a hashset
    def ind(self, key: int) -> int: # defining the hash function and returning the index
        
        return key % self.size
       
        
    def add(self, key: int) -> None:
        num = self.ind(key) # calls the hash function
        if self.set[num] == None: # if the hashset is empty
            self.set[num] = [key] # here, is the twist that an inner list is created at a particular index
        else:
            self.set[num].append(key) # element is appended to the inner list of its correct position

    def remove(self, key: int) -> None:
        num = self.ind(key) # calls the hash function
        if self.set[num] is not None:
            while key in self.set[num]: # while loop to remove all the elements inside the inner list 
                self.set[num].remove(key) # remove the element from the listg
        

    def contains(self, key: int) -> bool:
        num = self.ind(key) # calls the hash function
        if self.set[num] != None: # if the list is not empty
            if key in self.set[num]: # if the element is present in the hashset
                return True

        return False # if the element is not present.
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
