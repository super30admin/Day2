# Time Complexity: O(1)
# Space Complexity: O(n)
class MyHashMap:

    def __init__(self):
        self.size=10000
        self.hashmap=[[] for _ in range(self.size)]

    def put(self, key: int, value: int) -> None:
        bucket, index=self.key_index(key)
        if index == -1:
            self.hashmap[bucket].append([key,value])
        else:
            self.hashmap[bucket][index][1]=value

    def get(self, key: int) -> int:
        bucket, index=self.key_index(key)
        if index != -1:
            del self.hashmap[bucket][index]

    def remove(self, key: int) -> None:
        bucket, index=self.key_index(key)
        if index!=-1:
            del self.hashmap[bucket][index]
            
    def hash_function(self, key):
        return key % self.size
    
    def key_index(self, key):
        bucket = self.hash_function(key)
        pairs=self.hashmap[bucket]
        for i in range(len(pairs)):
            if pairs[i][0]==key:
                return (bucket,i)
        return (bucket, -1)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)