class Node:
        def __init__(self, key,val):
            self.key = key
            self.value = val
            self.next = None
class MyHashMap:    

    def __init__(self):
        self.buckets = 1000
        self.storage = [None] * self.buckets
        
    def getBucket(self, key):
        return key % self.buckets

    def find(self, dummy, key):
        bucket = self.getBucket(key)
        prev = dummy
        curr = dummy.next
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        bucket = self.getBucket(key)
        if not self.storage[bucket]:
            dummy = Node(-1,-1)
            self.storage[bucket] = dummy
            dummy.next = Node(key,value)
        else:
            prev = self.find(self.storage[bucket],key)
            if not prev.next:
                prev.next = Node(key,value)
            else:
                prev.next.value = value

    def get(self, key: int) -> int:
        bucket = self.getBucket(key)
        if not self.storage[bucket]:
            return -1
        else:
            prev = self.find(self.storage[bucket],key)
            if prev.next:
                return prev.next.value
            else:
                return -1

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket]:
            prev = self.find(self.storage[bucket],key)
            if prev.next:
                prev.next = prev.next.next



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)