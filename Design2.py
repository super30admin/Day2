class MyHashSet:
  def __init__(self):
    self.buckets = 1000
    self.bucketItems = 1000
    self.storage = [None for i in range(self.buckets)]

  def hash1(self, key: int) -> int:
    return key % self.buckets

  def hash2(self, key):
    return key // self.bucketItems

  def add(self, key: int) -> None:
    h1 = self.hash1(key)
    h2 = self.hash2(key)
    if(self.storage[h1] == None):
        if(h1 == 0):
            self.storage[h1] = [None for i in range(self.bucketItems + 1)]
        else:
            self.storage[h1] = [None for i in range(self.bucketItems)]
    self.storage[h1][h2] = True


  def remove(self, key: int) -> None:
    h1 = self.hash1(key)
    h2 = self.hash2(key)
    if(not self.storage[h1]):
        pass    
    else:
        self.storage[h1][h2] = False

  def contains(self, key: int) -> bool:
    h1 = self.hash1(key)
    h2 = self.hash2(key)
    if(not self.storage[h1]):
        return False
    elif(self.storage[h1][h2]):
        return True
    else:
        return False
            
            
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
