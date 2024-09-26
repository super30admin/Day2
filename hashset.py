class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.capacity=8
        self.loadFactor=0.75
        self.size=0
        self.hashset=[None]*self.capacity
    def getHash(self,key ):
        return key%self.capacity

    def add(self, key: int) -> None:
        if float(self.size)/self.capacity >= self.loadFactor:
            self.capacity<<=1
            newhashset=[None]*self.capacity
            for i in range(self.capacity>>1):
                if self.hashset[i] is not None and self.hashset[i] !="DELETED":
                    h=self.getHash(self.hashset[i])
                    while newhashset[h] is not None:
                        h=(5*h+1) % self.capacity
                    newhashset[h]=self.hashset[i]
            self.hashset=newhashset
        h=self.getHash(key)
        while self.hashset[h] is not None:
            h=(5*h+1)%self.capacity
        self.hashset[h]=key
        self.size +=1

    def remove(self, key: int) -> None:
        h=self.getHash(key)
        while self.hashset[h] is not None:
            if self.hashset[h] ==key:
                self.hashset[h]="DELETED"
                self.size -=1
            else:
                h=(5*h+1)%self.capacity
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        h=self.getHash(key)
        while self.hashset[h] is not None:
            if self.hashset[h] == key:
                return True
            else:
                h=(5*h+1)%self.capacity
        return False
  


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)