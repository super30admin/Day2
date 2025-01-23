"""
Linked List Approach -
1. Implement a hashing mod function
2. Implement a find function to locate the key
3. for put, get, remove, use this find function to locate the key

TC - O(1)
SC - O(n)
"""


class LNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        self.buckets = [None] * 10000

    def hashFunction(self, key):
        return key % 1000

    def find(self, headnode, key):
        tempnode = headnode
        # find the key
        while tempnode.next is not None and tempnode.next.key != key:
            tempnode = tempnode.next
        return tempnode

    def put(self, key: int, value: int) -> None:
        # find index
        idx = self.hashFunction(key)
        # go to the index and check if LL present. If not initialize a LL
        if self.buckets[idx] is None:
            self.buckets[idx] = LNode(-1, -1)

        # implement the find function to search the location
        prev = self.find(self.buckets[idx], key)

        # if key not present
        if prev.next is None:
            prev.next = LNode(key, value)
        # if key is already present, update value
        prev.next.value = value

    def get(self, key: int) -> int:
        idx = self.hashFunction(key)

        # if LL is not present
        if self.buckets[idx] is None: return -1

        prev = self.find(self.buckets[idx], key)

        # if key not found
        if prev.next is None: return -1

        # key found, return value
        return prev.next.value

    def remove(self, key: int) -> None:
        idx = self.hashFunction(key)

        # if LL not present
        if self.buckets[idx] is None: return -1

        prev = self.find(self.buckets[idx], key)

        if prev.next is None: return -1

        # remove
        prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)