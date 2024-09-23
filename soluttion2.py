# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class MyHashMap:
    
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * self.buckets
        
    def getHash(self, key: int) -> int:
        return key % self.buckets

    def getPrev(self, head: 'Node', key: int) -> Node:
        prev = None
        curr = head
        
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        hash_key = self.getHash(key)
        
        if self.storage[hash_key] is None:
            self.storage[hash_key] = self.Node(-1, -1)

        prev = self.getPrev(self.storage[hash_key], key)

        if prev.next is None:
            prev.next = self.Node(key, value)
        else:
            prev.next.value = value


    def get(self, key: int) -> int:
        hash_key = self.getHash(key)
        if self.storage[hash_key] is None:
            return -1

        prev = self.getPrev(self.storage[hash_key], key)

        if prev.next is None:
            return -1
        else:
            return prev.next.value

        

    def remove(self, key: int) -> None:
        hash_key = self.getHash(key)
        if self.storage[hash_key] is None:
            return

        prev = self.getPrev(self.storage[hash_key], key)

        if prev.next is not None:
            prev.next = prev.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

