# time complexity remove  O(1)
# time complexity add O(1)
# time complexity contains O(1)
# Space compexity O(n*n)
class MyHashSet:

    def __init__(self):
        self.arr = [ [] for i in range(1000) ]
        self.h1 = 1000
        self.h2 = 1000

    def add(self, key: int) -> None:
        hash1 = key % self.h1

        if not self.arr[hash1]:
            if hash1 == 0:
                self.arr[hash1] = [0]*1001
            else:
                self.arr[hash1] = [0]*1000
        hash2 = key // self.h2
        self.arr[hash1][hash2] = 1            

    def remove(self, key: int) -> None:
        hash1 = key % self.h1 
        hash2 = key // self.h2 
        if self.arr[hash1]:
            self.arr[hash1][hash2] = 0

    def contains(self, key: int) -> bool:
        hash1 = key % self.h1 
        hash2 = key // self.h2 
        return False if not self.arr[hash1] else self.arr[hash1][hash2] 
            
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
    

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)