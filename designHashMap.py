class MyHashMap:
    class Node:
        def __init__(self, key: int, value:int):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.buckets = 10000 # to reduce the length of LL to 100 so that searching time also dec
        self.storage = [None] * self.buckets
    
    def getBucket(self, key:int) -> int:
        return key % self.buckets
    
    def find(self, key: int, node: Node) -> Node:
        prev = node
        curr = prev.next
        while curr != None and curr.key != key:
            prev = curr
            curr = prev.next
        return prev      

    def put(self, key: int, value: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            self.storage[bucket] = self.Node(-1,-1)
        prev = self.find(key, self.storage[bucket])
        if prev.next == None:
            prev.next = self.Node(key, value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return -1
        prev = self.find(key, self.storage[bucket])
        if prev.next == None:
            return -1
        else:
            return prev.next.value
        
    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return
        prev = self.find(key, self.storage[bucket])
        if prev.next == None:
            return
        else:
            prev.next = prev.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
