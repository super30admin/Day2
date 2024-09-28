# implemented hashset using double hashing
# time compexity is o(1)


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size=10000 #capacity
        self.set=[None]*self.size # set values
    
    def hash(self, key):
        return key%self.size # defining the hash function 
       

    def add(self, key):
        """
        :type key: int
        :rtype: void
        """
        if self.contains(key): #checking if the key is present or not 
            return 
        
        index=self.hash(key) 
        if not self.set[index]:
            self.set[index]=[]# if not inserting the value inside array
        self.set[index].append(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: void
        """
        if not self.contains(key):
            return
        index=self.hash(key)
        self.set[index].remove(key) #removing the particula key element
        
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        index=self.hash(key)
        
        if not self.set[index]:
            return False
        for i in self.set[index]: # checking key is prsent inside the array
            if i==key:
                return True
        return False
            
       