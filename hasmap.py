'''
Time Complexity: O(1)
Space Complexity: O(N)
'''
class MyHashMap:

    def __init__(self, bucket = 1000, sbucket=1000):
        self.bucket = bucket
        self.sbucket = sbucket
        self.primarr = [None]*bucket
    
    def put(self, key: int, value: int) -> None:
        bval = key % self.bucket
        if(not self.primarr[bval]):
            sbucket = self.sbucket
            if(bval == 0):
                sbucket += 1
            self.primarr[bval] = [-1]*sbucket
        sbval = int(key/self.sbucket)
        self.primarr[bval][sbval] = value

    def get(self, key: int) -> int:
        bval = key % self.bucket
        if(not self.primarr[bval]):
            return -1
        sbval = int(key/self.sbucket)
        return self.primarr[bval][sbval]
        

    def remove(self, key: int) -> None:
        bval = key % self.bucket
        sbval = int(key/self.sbucket)
        if(not self.primarr[bval]):
            return -1
        sbval = int(key/self.sbucket)
        self.primarr[bval][sbval] = -1
        

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)