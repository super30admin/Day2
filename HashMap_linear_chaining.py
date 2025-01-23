#Time Complexity: O(1)
#Space complexity: O(n)

class MyHashMap:
    def __init__(self):
        self.bucketSize = 1000
        self.storage = [None] * self.bucketSize

    class Node:
        def __init__(self, key: int, value: int):
            self.key = key
            self.value = value
            self.next = None

    def search(self, head: Node, key: int):
        prev = head
        if prev != None:
            curr = head.next
            while(curr != None and curr.key != key):
                prev = curr
                curr = curr.next
        return prev

    def getHash(self, key):
        return key % self.bucketSize

    def put(self, key: int, value: int) -> None:
        index = self.getHash(key)
        prev = self.search(self.storage[index], key)
        if prev != None:
            if prev.next != None:
                prev.next.value = value
            else: prev.next = self.Node(key, value)
        else:
            node = self.Node(-1, -1)
            self.storage[index] = node
            node.next = self.Node(key, value)

    def get(self, key: int) -> int:
        index = self.getHash(key)
        prev = self.search(self.storage[index], key)
        if prev != None and prev.next != None:
            return prev.next.value
        else:
            return -1
        

    def remove(self, key: int) -> None:
        index = self.getHash(key)
        prev = self.search(self.storage[index], key)
        if prev != None and prev.next != None:
            prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)