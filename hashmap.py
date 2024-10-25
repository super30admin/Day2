class ListNode:
    def __init__(self, key: int, value: int):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.hashTable = [None] * self.size
    
    def hashFunction(self, val):
        return val % self.size

    def put(self, key: int, value: int) -> None:
        hashVal = self.hashFunction(key)

        if self.hashTable[hashVal] == None:
            self.hashTable[hashVal] = ListNode(key, value)
            return
        else:
            curr = self.hashTable[hashVal]
            prev = None
            while curr:
                if curr.key == key:
                    curr.value = value
                    return
                prev = curr
                curr = curr.next
            
            if prev:
                prev.next = ListNode(key, value)
                return

    def get(self, key: int) -> int:
        hashVal = self.hashFunction(key)
        curr = self.hashTable[hashVal]

        while curr:
            if curr.key == key:
                return curr.value
            curr = curr.next
        return -1

    def remove(self, key: int) -> None:
        hashVal = self.hashFunction(key)
        curr = self.hashTable[hashVal]
        prev = None
        if curr == None:
            return
        if curr.key == key:
            self.hashTable[hashVal] = curr.next
            curr.next = None
            return
        while curr:
            if curr.key == key:
                prev.next = curr.next
                curr.next = None
                return

            prev = curr
            curr = curr.next
        return
