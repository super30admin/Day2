// Time Complexity : O(k) where k = bucket size
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Bucket :
    def __init__(self):
        self.bucket = []
    
    def put(self, key, value) :
        #if key exists then overwrite the value else append in the bucket
        flag = True
        for i in range(len(self.bucket)) :
                if self.bucket[i][0] == key :
                    self.bucket[i] = (key, value)
                    flag = False
        if flag :
            self.bucket.append((key, value))
            
    def get(self, key) :
        for (k, v) in self.bucket :
            if k == key :
                return v
        return -1
    
    def remove(self, key) :
        index = -1
        for i in range(len(self.bucket)) :
            if self.bucket[i][0] == key :
                index = i
                break
        if index != -1 :
            del self.bucket[index]
                
    
class MyHashMap:

    def __init__(self):
        self.modulo = 2081
        self.hashMap = [Bucket() for i in range(self.modulo)]
        

    def put(self, key: int, value: int) -> None:
        hashKey = key % self.modulo
        self.hashMap[hashKey].put(key, value)
        

    def get(self, key: int) -> int:
        hashKey = key % self.modulo
        return self.hashMap[hashKey].get(key)

    def remove(self, key: int) -> None:
        hashKey = key % self.modulo
        self.hashMap[hashKey].remove(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
