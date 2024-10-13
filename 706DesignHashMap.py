class MyHashMap:
    class Node:
        def __init__(self, key=None, value=None, next=None):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.storage = [None] * 10000

    def hash_func(self, key):
        return key % 10000

    def find(self, head, key):
        curr = head
        prev = None
        while (curr != None and curr.key != key):
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        hash_val = self.hash_func(key)
        if self.storage[hash_val] == None:
            self.storage[hash_val] = self.Node(-1, -1, None)
        prev = self.find(self.storage[hash_val], key)
        if prev.next == None:
            prev.next = self.Node(key, value, None)
        else:
            prev.next.value = value  # Updating the value

    def get(self, key: int) -> int:
        hash_val = self.hash_func(key)
        if self.storage[hash_val] == None:
            return -1
        else:
            prev = self.find(self.storage[hash_val], key)
            if prev.next != None:
                return prev.next.value
            else:
                return -1

    def remove(self, key: int) -> None:
        hash_val = self.hash_func(key)
        if self.storage[hash_val] == None:
            return
        prev = self.find(self.storage[hash_val], key)
        if prev.next != None:
            prev.next = prev.next.next1
        else:
            return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)