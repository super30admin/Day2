'''
    Time Complexity:
        Mentioned for every method in the code.

    Space Complexity:
        O(n)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        initialized bucket as:
            [List()] * bucket_size
        instead of:
            [List() for _ in range(bucket_size)]

        And spent a ton of time debugging.

    Approach:
        LinkedList as Bucket
'''
class List:
    class Node:
        def __init__(self, data = None, next = None):
            self.data = data
            self.next = next


    def __init__(self):
        self._DUMMY = self.Node()
        self.head = self._DUMMY


    def add(self, data):                                        # O(n)
        prev = self._find_prev(data)
        if prev.next is not None:
            return
        prev.next = self.Node(data)


    def remove(self, data):                                     # O(n)
        prev = self._find_prev(data)
        if prev.next is None:
            return
        prev.next = prev.next.next


    def contains(self, data):                                   # O(n)
        prev = self._find_prev(data)
        return prev.next is not None


    def _find_prev(self, data):
        walk = self.head
        while walk.next is not None and walk.next.data != data:
            walk = walk.next
        return walk


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self._bkt_size = 10000
        self._bucket = [List() for _ in range(self._bkt_size)]


    def add(self, key: int) -> None:                            # O(1)
        bkt = self._bkt(key)
        self._bucket[bkt].add(key)


    def remove(self, key: int) -> None:                         # O(1)
        bkt = self._bkt(key)
        self._bucket[bkt].remove(key)


    def contains(self, key: int) -> bool:                       # O(1)
        """
        Returns true if this set contains the specified element
        """
        bkt = self._bkt(key)
        return self._bucket[bkt].contains(key)


    def _bkt(self, key):
        return key % self._bkt_size


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
