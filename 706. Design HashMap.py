# I initialize an empty array of length 1000, which contains listNode (linked list) of key & value of value -1 as dummy node
# for put operation, i handle the key indexing by modding the key by length of our array (ie 1000). if there are collisions at the same index for different keys, i simply make a new node and put the value alongwith the key
# with this uniform chaining, we can establish Average run time of put , get , remove operations are to be O(1)

class ListNode:

    def __init__(self, key = -1, value = -1, next = None):
        self.key = key
        self.value = value
        self.next = next

class MyHashMap:

    def __init__(self):
        self.hMap = [ListNode() for i in range(1000)]
        
    def put(self, key: int, value: int) -> None:
        idx = (key % 1000)
        cur  = self.hMap[idx]

        while(cur.next):
            if cur.next.key == key:
                cur.next.value = value
                return
            cur = cur.next

        cur.next = ListNode(key, value)
        
    def get(self, key: int) -> int:
        idx = (key % 1000)
        cur  = self.hMap[idx].next

        while(cur):
            if cur.key == key:
                return cur.value
            cur = cur.next
            
        return -1
                
            
    def remove(self, key: int) -> None:
        idx = (key % 1000)
        cur  = self.hMap[idx]

        while cur.next:
            if (cur.next.key == key):
                cur.next = cur.next.next

                return
            cur = cur.next



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
