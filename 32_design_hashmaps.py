# Time complexity -
#     put() - O(n)
#     get() - O(n)
#     remove() - O(n)

# Space complexity - O(n)

# Approach - modulo function for hashing key and linked list for collision resolution

class ll:
    def __init__(self, key = -1, val = -1, next = None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:
    def __init__(self):
        self.map = []

        for _ in range(1000):
            self.map.append(ll())

    def put(self, key: int, value: int) -> None:
        hash = key % len(self.map)
        cur = self.map[hash]

        while cur.next:
            if cur.next.key == key:
                cur.next.val = value
                return       
            cur = cur.next
        cur.next = ll(key, value)

    def get(self, key: int) -> int:
        hash = key % len(self.map)
        cur = self.map[hash]

        while cur.next:
            if cur.next.key == key:
                return cur.next.val
            cur = cur.next
        return -1
        
    def remove(self, key: int) -> None:
        hash = key % len(self.map)
        cur = self.map[hash]

        while cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return
            cur = cur.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)