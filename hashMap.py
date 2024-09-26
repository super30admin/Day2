#Leetcode Problem: 706

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket=1000
        self.bucketItems=1000
        self.hm=[False]*self.bucket
        

    def getFirstHash(self,key): #Time Complexity: O(1)
        return key % self.bucket

    def getSecondHash(self,key): #Time Complexity: O(1)
        return key//self.bucketItems
    
    def put(self, key, value): #Time Complexity: O(1)
        """
        value will always be non-negative.
        """
        #Using double hashing put the correct value in particular position.
        firstHashVal=self.getFirstHash(key)
        secoondHashVal=self.getSecondHash(key)
        if self.hm[firstHashVal]==False:
            if firstHashVal==0:
                self.hm[firstHashVal]=[-1]*(self.bucketItems+1)
            else:
                self.hm[firstHashVal]=[-1]*(self.bucketItems)
        self.hm[firstHashVal][secoondHashVal]=value
        
                

    def get(self, key): #Time Complexity: O(1)
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        #Using double hashing get the correct value from particular position.
        firstHashVal=self.getFirstHash(key)
        secoondHashVal=self.getSecondHash(key)
        if self.hm[firstHashVal]==False:
            return -1
        return self.hm[firstHashVal][secoondHashVal]
      

    def remove(self, key): #Time Complexity: O(1)
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        #Using double hashing we can remove element by just changing its value to -1
        firstHashVal=self.getFirstHash(key)
        secoondHashVal=self.getSecondHash(key)
        if self.hm[firstHashVal]==False:
            return
        self.hm[firstHashVal][secoondHashVal]=-1
        
        
        
#Time complexity: O(1)
#Space complexity: Worst case O(upperBound) in this case 10^6

#Leetcode status: All test cases passed.

#Here we have time and space tradeoff, to achieve efficiency we have used more space. This could be done using separate chaining too.

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)