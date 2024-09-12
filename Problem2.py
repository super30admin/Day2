"""
705. Design HashSet
Time Complexity - 
add- O(1)
remove - O(1)
contains - O(1)
Space Complexity - O(1)
Here I have made a hash set for 1001*1001 matrix where as given max limit would be 10^6

To add an element divide that element by 1000 this will give us the row where element will be present then by dividing by 1000 we will get column which we set as True indicating that element is present

To remove an element
Divide that element by 1000 this will give us the row where element will be present then by dividing by 1000 we will get column which we set as False indicating that element is deleted

To check if that element is present in hashset
Divide that element by 1000 this will give us the row where element will be present then by dividing by 1000 we will get column which if true then element is present else element is not present

"""
class MyHashSet:
    
    def __init__(self):
        self.hashset = [None]*1001
        
    def add(self, key: int) -> None:
        index1 = key % 1000
        index2 = key // 1000
        
        if self.hashset[index1] == None:
            self.hashset[index1] = [None] * 1001
        
        self.hashset[index1][index2] = True      

    def remove(self, key: int) -> None:
        index1 = key % 1000
        index2 = key // 1000
        
        if self.hashset[index1] != None:
            self.hashset[index1][index2] = False

    def contains(self, key: int) -> bool:
        index1 = key % 1000
        index2 = key // 1000    
        if self.hashset[index1] != None:
            return self.hashset[index1][index2]
        
        return False
        
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)