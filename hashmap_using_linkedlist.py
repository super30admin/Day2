"Time Complexity is O(1) on average for put, get, and remove operations. But in  worst case (when there are many collisions and elements are stored in the same bucket), the time complexity can go to O(N), where N is the number of elements in the hash map."
"Space Complexity is O(N)"

#Explanation
"We first inittate a primary data structure lists here with the length of root of maximum value"
"Secondary datastructre chosen here is linkedlist here"
"We will have to always store the prev node while traversing which will help us in all the three functions"

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