'''
    Used linear chaining for creating the hashmap.
'''

class ListNode:
    def __init__(self, key=-1, next=None):
        self.key = key
        self.next = next

class MyHashSet:
    def __init__(self):
        self.hashSet = [ListNode() for i in range(1000)]

    def hash(self, key): 
        return key % len(self.hashSet)
    
    def add(self, key: int) -> None:
        cur = self.hashSet[self.hash(key)]

        while cur.next:
            if cur.next.key == key:
                return

            cur = cur.next

        cur.next = ListNode(key)

    def remove(self, key: int) -> None:
        cur = self.hashSet[self.hash(key)]

        while cur and cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return

            cur = cur.next

    def contains(self, key: int) -> bool:
        cur = self.hashSet[self.hash(key)]

        while cur.next:
            if cur.next.key == key:
                return True

            cur = cur.next

        return False