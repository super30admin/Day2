class MyHashMap:

    def __init__(self):
        self.hmap = [None]*1001
        

    def get_index(self, val):
        index_1 = val//1000
        index_2 = val - index_1*1000

        return  index_1, index_2
        

    def put(self, key: int, value: int) -> None:
        index_1, index_2 =  self.get_index(key)

        if self.hmap[index_1] == None:
             self.hmap[index_1] = [None]*1000

        self.hmap[index_1][index_2] = value
        
    def get(self, key: int) -> int:
        index_1, index_2 =  self.get_index(key)
         #print("get",key, index_1, index_2, self.hmap[index_1][index_2])
        if self.hmap[index_1] != None:

            if self.hmap[index_1][index_2] != None:
                 #print("get",key, index_1, index_2, self.hmap[index_1][index_2])

                return self.hmap[index_1][index_2]
            else: return -1

        else:

             return -1


    def remove(self, key: int) -> None:
        index_1, index_2 =  self.get_index(key)

        if self.hmap[index_1] != None:
            self.hmap[index_1][index_2] = None

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)