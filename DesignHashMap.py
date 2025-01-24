# Time Complexity : Worst case - O(n) ; Best case - O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class ListNode:
    def __init__(self,key,val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:
    def __init__(self):
        self.capacity = 10000
        self.hashmap = [ListNode(0,0) for _ in range(self.capacity)]

    def put(self, key: int, value: int) -> None:
        index = key % self.capacity
        curr = self.hashmap[index]
        while curr.next:
            if curr.next.key == key:
                curr.next.val = value
                return
            curr = curr.next
        curr.next = ListNode(key,value)

    def get(self, key: int) -> int:
        index = key % self.capacity
        curr = self.hashmap[index]
        while curr.next:
            if curr.next.key == key:
                return curr.next.val
            curr = curr.next
        return -1
        

    def remove(self, key: int) -> None:
        index = key % self.capacity
        curr = self.hashmap[index]
        while curr.next:
            if curr.next.key == key:
                curr.next = curr.next.next
                return 
            curr = curr.next

