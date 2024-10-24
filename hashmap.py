# The code defines a simple hash map using a list of linked lists to handle collisions through linear chaining.
# Each position in the list starts with a dummy node (ListNode()), and actual key-value pairs are added as nodes in the linked list for each respective bucket, determined by the hash function (key % len(self.map)).
# The put method inserts or updates a key-value pair in the hash map. If the key already exists, it updates the value; otherwise, it appends a new node with the key-value pair.
# The get method retrieves the value associated with a key if it exists; otherwise, it returns -1.
# The remove method deletes a key-value pair from the hash map if the key exists.
# TC: 
#   - Put: O(1) average and O(n) worst case, 
#   - Get: O(1) average and O(n) worst case, 
#   - Remove: O(1) average and O(n) worst case
# SC: O(m + n) where m is the number of buckets (1000 in this case) and n is the number of unique key-value pairs stored in the hash map.



class ListNode:
    def __init__(self, key=-1, val=-1, next=None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:

    def __init__(self):
        self.map = [ListNode() for i in range(1000)]

    def hash(self, key):
        return key % len(self.map)

    def put(self, key: int, value: int) -> None:
        cur = self.map[self.hash(key)]
        while cur.next:
            if cur.next.key == key:
                cur.next.val = value
                return
            cur = cur.next
        cur.next = ListNode(key, value)  

    def get(self, key: int) -> int:
        cur = self.map[self.hash(key)].next
        while cur:
            if cur.key == key:
                return cur.val
            cur = cur.next
        return -1
        

    def remove(self, key: int) -> None:
        cur = self.map[self.hash(key)]
        while cur and cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return
            cur = cur.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)