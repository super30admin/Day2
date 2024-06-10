class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None

        
class LinkedList:
    def __init__(self):
        self.head = Node(None, None)

        
class MyHashMap:
    def __init__(self):
        self.size = 10000
        self.list = [LinkedList()] * self.size
    
    def _hash(self, key: int) -> int:
        return key % self.size
    
    def _find(self, key: int) -> Optional["Node"]:
        hash_value = self._hash(key)
        head_next = self.list[hash_value].head.next
        while head_next:
            if head_next.key == key:
                return head_next
            head_next = head_next.next
        return None
        
    def put(self, key: int, value: int) -> None:
        node = self._find(key)
        hash_value = self._hash(key)
        if node is not None:
            node.val = value
        else:
            new_node = Node(key, value)
            new_node.next = self.list[hash_value].head.next
            self.list[hash_value].head.next = new_node
        return None

    def get(self, key: int) -> int:
        node = self._find(key)
        return 1 if node is not None else -1

    def remove(self, key: int) -> None:
        hash_value = self._hash(key)
        prev = self.list[hash_value].head
        cur = prev.next
        while cur:
            if cur.key == key:
                break
            prev, cur = cur, cur.next
        if cur:
            prev.next = cur.next
        return None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

# Time Complexity : O(1)
# Space Complexity : O(1)