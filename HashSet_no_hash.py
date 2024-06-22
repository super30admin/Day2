"""
Time Complexity

O(1)ForPut,Get,And Remove Operations
Sure, here are the key points in a more concise, hand-written style:

1. **Separate Chaining**:
   - Uses linked lists to handle collisions.
   - Each bucket points to a linked list.

2. **Fixed-Size Array**:
   - Storage array size: 10,000.
   - Index: `key % 10000`.

3. **Find Function**:
   - Helps locate the key in the linked list.
   - Returns the previous node.

4. **Dummy Head Node**:
   - Simplifies insert/delete operations.
   - Each list starts with `Node(-1, -1)`.
Space Complexity - O(N)

"""



class MyHashMap:

    def __init__(self):
        self.storage = [None] * 10000

    class Node:
        def __init__(self, key, val):
            self.val = val
            self.key = key
            self.next = None

    def find(self, head, key):
        prev = None
        curr = head
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def index(self, key):
        return key % 10000

    def put(self, key: int, value: int) -> None:
        idx = self.index(key)
        if self.storage[idx] is None:
            self.storage[idx] = self.Node(-1, -1)
        prev = self.find(self.storage[idx], key)
        if prev.next is None:
            # key doesn't exist
            prev.next = self.Node(key, value)
        else:
            prev.next.val = value

    def get(self, key: int) -> int:
        idx = self.index(key)
        if self.storage[idx] is None:
            return -1
        prev = self.find(self.storage[idx], key)
        if prev.next is None:
            return -1
        return prev.next.val

    def remove(self, key: int) -> None:
        idx = self.index(key)
        if self.storage[idx] is None:
            return None
        prev = self.find(self.storage[idx], key)
        if prev.next is not None:
            temp = prev.next
            prev.next = prev.next.next
            temp.next = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
