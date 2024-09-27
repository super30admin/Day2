class MyHashMap:

    def __init__(self):
        self.no_buckets = 1000
        self.buckets = [-1]*self.no_buckets

    def put(self, key: int, value: int) -> None:
        
        ind = key % (self.no_buckets)
        if(self.buckets[ind] == -1):
            self.buckets[ind] = [[key,value]]
            return
        for i , kb in enumerate(self.buckets[ind]):
            if kb[0] == key:
                self.buckets[ind][i][1]=value
                return
        self.buckets[ind].append([key,value])
        return
    
    def get(self, key: int) -> int:
        ind = key % (self.no_buckets)
        
        if(self.buckets[ind] == -1):
            return -1
        for i , kb in self.buckets[ind]:
            if i == key:
                return kb
        return -1

    def remove(self, key: int) -> None:
        ind = key % (self.no_buckets)
        ind_to_rem = -1
        if(self.buckets[ind] == -1):
            return
        for i , kb in enumerate(self.buckets[ind]):
            if kb[0] == key:
                ind_to_rem = i
                break
        if ind_to_rem ==-1:        
            return
        else:
            del self.buckets[ind][ind_to_rem]


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)