# Time Complexity : add O(1) contain O(1) remove O(1)
# Space Complexity :???

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket=1000
        self.bucketitem=1001
        self.storage=[None for i in range(self.bucket)]

    def hash1(self,key):
        return key % 1000

    def hash2(self,key):
        return key//1000



    def add(self, key: int) -> None:
        index1=self.hash1(key)
        index2=self.hash2(key)
        if self.storage[index1]==None:
               self.storage[index1]=[None for i in range(self.bucketitem)]

        self.storage[index1][index2]=True

    def remove(self, key: int) -> None:
        index1=self.hash1(key)
        index2=self.hash2(key)
        #print(self.storage[index1])
        if self.storage[index1]==None:
            return

        self.storage[index1][index2]=None



    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index1=self.hash1(key)
        index2=self.hash2(key)

        if self.storage[index1]==None or self.storage[index1][index2]==None :
            return False
        else:
            return self.storage[index1][index2]



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
