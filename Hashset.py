# Time Complexity :O(N) for inserting and O(1) for remove
# Space Complexity :
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class MyHashSet:

    def __init__(self):
        self.size=10000
        self.hs=[None]*self.size
    
    def hashing(self,key:int):
        return key % self.size
        
    def add(self, key: int) -> None:
        val=self.hashing(key)
        if self.hs[val] !=None:
            self.hs[val].append(key)
        else:
            self.hs[val]=[key]

    def remove(self, key: int) -> None:
        val=self.hashing(key)
        if self.hs[val] !=None:
            while key in self.hs[val]:
                self.hs[val].remove(key)  

    def contains(self, key: int) -> bool:
        val=self.hashing(key)
        if self.hs[val] !=None:
            if key in self.hs[val]:
                return True
            else:
                return False
ob = MyHashSet()
ob.add(1)
ob.add(2)
print(ob.contains(1))
print(ob.contains(3))
ob.add(2)
print(ob.contains(2))
ob.remove(2)
print(ob.contains(2))

# Your code here along with comments explaining your approach
