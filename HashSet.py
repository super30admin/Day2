class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.set=[-1]*100000


    def add(self, key: int) -> None:
        hash_key=key%len(self.set)
        self.set[hash_key] = key


    def remove(self, key: int) -> None:
        hash_key=key%len(self.set)
        self.set[hash_key]=-1


    def contains(self, key: int) -> bool:

        """
        Returns true if this set contains the specified element
        """
        hash_key=key%len(self.set)
        return self.set[hash_key]==key


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(8)
obj.add(15)
obj.add(18)
obj.remove(8)
param_3 = obj.contains(15)