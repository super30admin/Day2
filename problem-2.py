# Time Complexity : put, get, remove - O(n)
# Space Complexity : Space complexity - O(k + n), k = 997
# Did this code successfully run on Leetcode : yes


class Node:
    def __init__(self, key=-1, val=-1, next=None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:
    def __init__(self):
        self.size = 997
        self.map = [Node() for _ in range(self.size)]
        
    def _hash(self, key):
        return key % len(self.map)
    
    def put(self, key: int, val: int) -> None:
        head = self.map[self._hash(key)]
        while head.next:
            if head.next.key == key:
                head.next.val = val
                return
            head = head.next
        head.next = Node(key, val)

    def get(self, key: int) -> int:
        head = self.map[self._hash(key)]
        while head.next:
            if head.next.key == key:
                return head.next.val
            head = head.next
        return -1

    def remove(self, key: int) -> None:
        head = self.map[self._hash(key)]
        while head.next:
            if head.next.key == key:
                head.next = head.next.next
                return
            head = head.next
        
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
