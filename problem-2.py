# // Time Complexity :O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : YES
class MyHashSet:

    def __init__(self):
        self.list1=[None]*1000
        
    def loc(self, key:int):
        first=key%1000
        second=key//1000
        return [first,second]
    
    def add(self, key: int) -> None:
        ind=self.loc(key)
        if self.list1[ind[0]]==None:
            self.list1[ind[0]]=[None]*10000
        self.list1[ind[0]][ind[1]]=key
        

    def remove(self, key: int) -> None:
        ind=self.loc(key)
        if self.list1[ind[0]]==None:
            return
        if self.list1[ind[0]][ind[1]]==key:
            self.list1[ind[0]][ind[1]]=None
    
    def contains(self, key: int) -> bool:
        ind=self.loc(key)
  
        if self.list1[ind[0]]==None:
            return False
        if self.list1[ind[0]][ind[1]]==key:
            return True
        else:
            return False
