#Time Complexity : O(1) for add() and remove(), search O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class MyHashSet:

    def __init__(self):
        self.size=1000
        self.data=[None]*self.size
        
    def hashFun(self,key):
        return key % self.size
        

    def add(self, key: int) -> None:
        index = self.hashFun(key)
        if self.data[index]==None:
            self.data[index]=[key]
        else:
            self.data[index].append(key)
        

    def remove(self, key: int) -> None:
        index = self.hashFun(key)
        if self.data[index]!=None:
            while key in self.data[index]:
                self.data[index].remove(key)
        

    def contains(self, key: int) -> bool:
        index = self.hashFun(key)
        if self.data[index]!=None:
            return key in self.data[index]
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)