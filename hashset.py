'''
Use double hashing where, primary array points to a secondary array of keys. When a element is added find the primary bucket and then find the secondary bucket using
hash functions.

Time complexity: O(1)
Space Complexity: Amortized O(1)

Runs successfully in leetcode
'''

class MyHashSet:

    def __init__(self):
        self.hashset = [None]*1000
        
    def prim_bucket(self,key):
        return key%1000
    
    def sec_bucket(self,key):
        return key//1000

    def add(self, key: int) -> None:
        
        #Time complexity: O(1) 
        #Check if array is created for given key and create an array if needed
        
        if(self.hashset[self.prim_bucket(key)] == None):
            if self.prim_bucket(key) == 0:
                self.hashset[self.prim_bucket(key)] = [False]*1001
            else:
                self.hashset[self.prim_bucket(key)] = [False]*1000
        #Add the element to the secondary array
        self.hashset[self.prim_bucket(key)][self.sec_bucket(key)] = True
                   
            

    def remove(self, key: int) -> None:
        
        #Time complexity: O(1)
        #Remove key by setting it to false
        
        if(self.hashset[self.prim_bucket(key)] != None):
            self.hashset[self.prim_bucket(key)][self.sec_bucket(key)] = False
            
        

    def contains(self, key: int) -> bool:
        
        #Time complexity: O(1)
        # Use hash function on key to find itf it is present
        
        if(self.hashset[self.prim_bucket(key)] != None):
            if(self.hashset[self.prim_bucket(key)][self.sec_bucket(key)] == True):
                 return self.hashset[self.prim_bucket(key)][self.sec_bucket(key)]
        return False
          
  
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
