#Time complexity of accessing an  element is O(1)
#Implementing a hashset[0,10^6] using Double hashing
#we will be using 2 hash functions: One for defining the primary array and other for secondary array
class MyHashSet(object):

    def __init__(self):
        self.bucket=1000
        self.bucketItem=1000
        self.myHash= [None for i in range(self.bucket)]

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.bucketHash=key%self.bucket
        self.bucketItemHash=key//self.bucketItem
        if self.myHash[self.bucketHash]==None:
            if self.bucketHash==0:
                self.myHash[0]= [False for i in range(self.bucketItem + 1)]
            else:
                self.myHash[self.bucketHash]= [False for i in range(self.bucketItem)]
        self.myHash[self.bucketHash][self.bucketItemHash]=True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.bucketHash=key%self.bucket
        self.bucketItemHash=key//self.bucketItem
        if self.myHash[self.bucketHash]!=None:
            self.myHash[self.bucketHash][self.bucketItemHash]=False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        self.bucketHash=key%self.bucket
        self.bucketItemHash=key//self.bucketItem
        if self.myHash[self.bucketHash]==None:
            return False
        elif self.myHash[self.bucketHash][self.bucketItemHash]==True :
            return True
        else:
            return False
        
        


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(4)
param_3 = obj.contains(4)
print(param_3)
obj.remove(4)
param_3 = obj.contains(4)
print(param_3)