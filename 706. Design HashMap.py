# Space Complexity O(n) in the worst case
class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        self.bucket = 1000
        self.hash_map = [None] * self.bucket

    def get_hash(self, key):
        return key % self.bucket

    def find_next(self, key):
        _hash = self.get_hash(key)
        if self.hash_map[_hash]:
            prev = self.hash_map[_hash]
            curr = prev.next

            while curr is not None and curr.key != key:
                prev = curr
                curr = curr.next
            return prev
        else:
            return None

    def put(self, key: int, value: int) -> None:
        # TimeComplexity is O(n). n is keySize/bucketSize. Amortised Case O(1)
        prev = self.find_next(key)

        if prev is None:
            _hash = self.get_hash(key)
            self.hash_map[_hash] = ListNode(-1, -1)
            prev = self.hash_map[_hash]

        if prev.next is None:
            prev.next = ListNode(key, value)
        else:
            prev.next.value = value

        print(self.hash_map)

    def get(self, key: int) -> int:
        # TimeComplexity is O(n).  n is keySize/bucketSize. Amortised Case O(1)
        prev = self.find_next(key)

        if prev is None or prev.next is None:
            return -1

        return prev.next.value

    def remove(self, key: int) -> None:
        # TimeComplexity is O(n).  n is keySize/bucketSize. Amortised Case O(1)
        prev = self.find_next(key)

        if prev and prev.next:
            prev.next = prev.next.next
