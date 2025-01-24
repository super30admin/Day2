'''
// Time Complexity : O(1)
// Space Complexity O(n)
// Did this code successfully run on Leetcode : yes.(#706)
// Any problem you faced while coding this : No.
'''
class ListNode:
    def __init__(self, key, val, next=None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:

    def __init__(self):
        self.map = [None] * 1000

    def put(self, key: int, value: int) -> None:
        bucket = self.bucketHash(key)
        if not self.map[bucket]:
            self.map[bucket] = ListNode(-1,-1)
        prev = self._search(self.map[bucket], key)
        if prev.next:
            prev.next.val = value
        else:
            prev.next = ListNode(key,value)

    def _search(self, head, key):
        tmpNode = head
        while tmpNode.next and tmpNode.next.key!=key:
            tmpNode = tmpNode.next
        return tmpNode

    def get(self, key: int) -> int:
        bucket = self.bucketHash(key)
        if not self.map[bucket]:
            return -1
        prev = self._search(self.map[bucket],key)
        if prev.next:
            return prev.next.val
        return -1

    def remove(self, key: int) -> None:
        bucket = self.bucketHash(key)
        if not self.map[bucket]:
            return
        prev = self._search(self.map[bucket], key)
        if prev.next:
            curr = prev.next
            prev.next = curr.next

    def bucketHash(self, ele):
        return ele % 1000
    

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(10,100)
print(obj.get(10))
obj.put(10,200)
print(obj.get(10))
obj.put(20,300)
print(obj.get(20))
obj.remove(20)
print(obj.get(20))