class Node:
    def __init__(self, key=-1, val=-1, next=None):
        self.key = key
        self.val = val
        self.next = next


class MyHashMap:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data = [None] * 1000  # Use None instead of Node()

    def hashcode(self, key):
        return key % len(self.data)

    def put(self, key: int, value: int) -> None:
        hashcode = self.hashcode(key)
        if self.data[hashcode] is None:
            self.data[hashcode] = Node(key, value)
            return
        
        head = self.data[hashcode]
        while head:
            if head.key == key:
                head.val = value
                return
            if head.next is None:
                break
            head = head.next
        head.next = Node(key, value)

    def get(self, key: int) -> int:
        hashcode = self.hashcode(key)
        head = self.data[hashcode]
        while head:
            if head.key == key:
                return head.val
            head = head.next
        return -1

    def remove(self, key: int) -> None:
        hashcode = self.hashcode(key)
        head = self.data[hashcode]
        prev = None
        while head:
            if head.key == key:
                if prev:
                    prev.next = head.next
                else:
                    self.data[hashcode] = head.next
                return
            prev, head = head, head.next
