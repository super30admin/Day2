class ListNode:
    def __init__(self, key: int, value: int):
        self.key = key
        self.value = value
        self.next = None  # Pointer to the next node
class MyHashMap:

    def __init__(self):
        self.buckets = [None] * 10000
    
    def getprev(self, key:int, head:ListNode):
        prev = ListNode(-1,-1)
        current = head
        prev.next = current
        
        while current!=None and current.key!=key:
            prev = current
            current = current.next

        return prev

    def put(self, key: int, value: int) -> None:
        primaryidx = key % len(self.buckets)

        if self.buckets[primaryidx] is None:
            self.buckets[primaryidx] = ListNode(-1,-1)
        
        prev = self.getprev(key, self.buckets[primaryidx])

        if prev.next is None:
            prev.next = ListNode(key, value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        primaryidx = key % len(self.buckets)

        if self.buckets[primaryidx] is None:
            return -1
        
        prev = self.getprev(key, self.buckets[primaryidx])

        if prev.next is None:
            return -1
        else:
            return prev.next.value

    
    def remove(self, key: int) -> None:
        primaryidx = key % len(self.buckets)

        if self.buckets[primaryidx] is None:
            return -1
        
        prev = self.getprev(key, self.buckets[primaryidx])

        if prev.next is None:
            return -1
        else:
            prev.next = prev.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)