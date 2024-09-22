class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.size = 10**4
        self.buckets = [None for _ in range(self.size)]

    def _hash(self, key):
        return key % self.size

    def put(self, key: int, value: int) -> None:
        index = self._hash(key)

        #if bucket is empty, create new ListNode
        if not self.buckets[index]:
            self.buckets[index] = ListNode(key, value)
        else:
            current = self.buckets[index]
            while True:
                if current.key == key:
                    current.value = value
                    return
                if not current.next:
                    current.next = ListNode(key, value)
                    return
                current = current.next
                
    def get(self, key: int) -> int:
        index = self._hash(key)
        current = self.buckets[index]

        while current:
            if current.key == key:
                return current.value
            else:
                current = current.next
        return -1

    def remove(self, key: int) -> None:
        index = self._hash(key)
        current = self.buckets[index]

        #if empty, do nothing
        if not current:
            return
        #if found on 1st node
        if current.key == key:
            self.buckets[index] = current.next
            return
        #traverse
        while current.next:
            if current.next.key == key:
                current.next = current.next.next
                return
            current = current.next




# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)