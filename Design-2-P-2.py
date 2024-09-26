class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset = [-1] * (10000000 - 1)

    def add(self, key) :

        self.hashset[key] = key

    def remove(self, key) :

        self.hashset[key] = -1

    def contains(self, key) :
        """
        Returns true if this set contains the specified element
        """
        if self.hashset[key] != -1:
            print "True"
        else:
            print "False"

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
obj.remove(1)
obj.contains(2)
