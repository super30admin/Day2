class Node:
    def __init__(self,data):
        self.data = data,
        self.value = None
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashmap = [None] * 10000
    def _hash(self,data):
        return hash(data) % 10000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self._hash(key)
        if self.hashmap[index] is None:
            self.hashmap[index] = Node((key,value))
        else:
            current = self.hashmap[index]
            while current:
                k, v = current.data
                if k == key:
                    current.data = (key,value)
                    return
                if current.next is None:
                    break
                else:
                    current = current.next
            

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self._hash(key)
        if self.hashmap[index] is None:
            return -1
        current = self.hashmap[index]
        while current:
            k, v = current.data
            if k == key:
                return v
            current = current.next
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self._hash(key)
        if self.hashmap[index] is None:
            return -1
        current = self.hashmap[index]
        newNode = [0]
        newNode.next = current
        while curr and curr.next:
            k, v = curr.next
            if k == key:
                cur.next = cur.next.next
            cur = cur.next
        self.hashmap[index] = newNode.next