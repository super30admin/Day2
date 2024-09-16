// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
'''
1. use hash functions to store the values.
2. When adding values check if value is present or not.
3. If present do nothing else add the element to array
4. When removing set the value to False

'''

class MyHashSet:
    
    def hash_helper1(self,val):
        return val%self.h1_helper
    
    def hash_helper2(self,val):
        return val//self.h2_helper

    def __init__(self):
        self.h1_helper=1000
        self.h2_helper=1000
        self.arr=[None for i in range(0,self.h1_helper)]
    

    def add(self, key: int) -> None:
        if not self.contains(key):
            hash1=self.hash_helper1(key)
            if hash1 ==0:
                self.arr[hash1]=[None for i in range(0,self.h1_helper+1)] # Edge case
            else:
                self.arr[hash1]=[None for i in range(0,self.h2_helper)]
                
            hash2=self.hash_helper2(key)
            self.arr[hash1][hash2]=True
            

    def remove(self, key: int) -> None:
        if self.contains(key):
            hash1=self.hash_helper1(key)
            hash2=self.hash_helper2(key)
            self.arr[hash1][hash2] =False
        

    def contains(self, key: int) -> bool:
        hash1=self.hash_helper1(key)
        
        if self.arr[hash1] == None:
            return False
        
        hash2=self.hash_helper2(key)
        return self.arr[hash1][hash2]
            