# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Node:
    def __init__(self, key, val, nextt=None):
        self.key=key
        self.val=val
        self.next=nextt

class MyHashMap:

    def __init__(self):
        self.storage=[None]*10000

    def put(self, key: int, value: int) -> None:
        bucket=key%10000
        if not self.storage[bucket]:
            self.storage[bucket] = Node(-1,-1)
        prev=self.search(self.storage[bucket],key)
        if prev.next:
            prev.next.val=value
        else:
            prev.next= Node(key, value)

    def search(self, head, key):
        curr=head
        while curr.next and curr.next.key!=key:
            curr=curr.next
        return curr

    def get(self, key: int) -> int:
        bucket=key%10000
        if not self.storage[bucket]:
            return -1
        curr = self.search(self.storage[bucket],key)
        if curr.next:
            return curr.next.val
        return -1

    def remove(self, key: int) -> None:
        bucket=key%10000
        if not self.storage[bucket]:
            return -1
        curr = self.search(self.storage[bucket],key)
        if curr.next:
            nextt=curr.next
            curr.next=nextt.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)