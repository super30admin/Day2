#Time complexity : All are O(n), n being the number of elements present in the set_table
#Space complexity: O(n) 

#creating a list
# For add function: Check if key already exists using contain function, if not append the key to the list.
# For remove function: Check if that particular key exists, if so remove that element using remove()
# For contains function: Check by traversing the  set_table, if the key exists.
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.set_table=[]
        

    def add(self, key: int) -> None:
        
        if not self.contains(key):
            self.set_table.append(key)
            

    def remove(self, key: int) -> None:
        if self.contains(key):
            self.set_table.remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return key in self.set_table


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
