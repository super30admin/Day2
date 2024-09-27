# // Time Complexity :O(1)
# // Space Complexity :O(1000)
class MyHashMap:

    def __init__(self):
        self.hmap = [None for i in range(10000) ]
    

    def put(self, key: int, value: int) -> None:
        hash1 = key % 1000
        hash2=key//1000
        if self.hmap[hash1]==None:
            if hash1==0:
                self.hmap[hash1]=[None for i in range(1001)]
            else:
                self.hmap[hash1]=[None for i in range(1000)]
        self.hmap[hash1][hash2]=value
            
                
            
    def get(self, key: int) -> int:
        
        hash1 = key % 1000
        hash2=key//1000
        
        if self.hmap[hash1]==None:
            return -1
        elif self.hmap[hash1]:
            print("l",self.hmap[hash1][hash2])
            if self.hmap[hash1][hash2]==None:
                return -1
            else:
                return self.hmap[hash1][hash2]

    def remove(self, key: int) -> None:
        
        hash1 = key % 1000
        hash2=key//1000
        print(hash1,hash2)
        if self.hmap[hash1]==None:
            return 
        else:
            print(hash1,hash2)
            self.hmap[hash1][hash2]=None
        

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)