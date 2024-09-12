# Time Complexity: O(1)
# Space Complexity: O(n)

# The code ran on Leetcode

class Node(object):
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        
class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 10000
        self.bucketItems = [None] * self.buckets

    def put(self, key, val):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: void
        """
        bucket = hash(key) % self.buckets
        curr = self.bucketItems[bucket]

        while curr:
            if curr.key == key:
                curr.val = val
                return
            curr = curr.next
            
        node = Node(key, val)
        node.next = self.bucketItems[bucket]
        self.bucketItems[bucket] = node

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        bucket = hash(key) % self.buckets
        curr = self.bucketItems[bucket]

        while curr:
            if curr.key == key:
                return curr.val
            curr = curr.next
        
        return -1

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: void
        """
        bucket = hash(key) % self.buckets
        curr = self.bucketItems[bucket]
        while curr:
            if curr.key == key:
                curr.key = -1
                return
            curr = curr.next
        
        return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)