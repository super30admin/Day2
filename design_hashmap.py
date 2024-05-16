# Time Complexity : on average is O(1) & worst case scenario it's O(n) 
# Space Complexity : is O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach   
# taking the sqr root of the max values we arrive at setting the size of the initial array then we use linked lists to resolve collisions

class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
        
class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.buckets = [None] * self.size

    def put(self, key: int, value: int) -> None:
        index = key % self.size
        if self.buckets[index] is None:
            self.buckets[index] = ListNode(key, value)
        else:
            curr = self.buckets[index]
            while True:
                if curr.key == key:
                    curr.value = value
                    return
                if curr.next is None:
                    break
                curr = curr.next
            curr.next = ListNode(key, value)

    def get(self, key: int) -> int:
        index = key % self.size
        curr = self.buckets[index]
        while curr:
            if curr.key == key:
                return curr.value
            curr = curr.next
        return -1

    def remove(self, key: int) -> None:
        index = key % self.size
        curr = prev = self.buckets[index]
        if not curr:
            return
        if curr.key == key:
            self.buckets[index] = curr.next
        else:
            curr = curr.next
            while curr:
                if curr.key == key:
                    prev.next = curr.next
                    break
                prev, curr = prev.next, curr.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)