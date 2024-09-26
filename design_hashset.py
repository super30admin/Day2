#            time complexity    space complexity
# add()           O(1)                O(1)
# remove()        O(1)                O(1)
# contain()       O(1)                O(1)

class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hasset=[None]*1000

    def get_index1(self,key):
        return key%1000

    def get_index2(self,key):
        return key//1000

    def add(self, key: int) -> None:
        i=self.get_index1(key)
        if self.hasset[i] == None:
            self.hasset[i]=[None]*1000
            self.hasset[i][self.get_index2(key)] = key
        else:
            self.hasset[i][self.get_index2(key)] = key


    def remove(self, key: int) -> None:
        i = self.get_index1(key)
        if self.hasset[i] != None:
            j=self.get_index2(key)
            if self.hasset[i][j] != None:
                self.hasset[i][j] = None

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        i = self.get_index1(key)
        if self.hasset[i] != None:
            j = self.get_index2(key)
            if self.hasset[i][j] != None:
                return True
            else:
                return False

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()

obj.add(10004)
obj.add(1004)
obj.add(14)
obj.add(104)
obj.add(4)
obj.remove(104)
obj.remove(12)
print(obj.contains(1004))
print(obj.contains(104))
