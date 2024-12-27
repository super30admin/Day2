# Time Complexity : 0(n)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes Bit of Python and Java Confusion


class MyHashMap(object):

    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.bucket_size = 1000
        self.bucket = [None] * self.bucket_size

    def Hash1(self, key):
        return key % self.bucket_size

    def find(self, head, key):
        previous = head
        curr = head.next if head else None  
        while curr is not None and curr.key != key:
            previous = curr
            curr = curr.next
        return previous

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        index = self.Hash1(key)
        if self.bucket[index] is None:
            self.bucket[index] = self.Node(-1, -1) 
        previous = self.find(self.bucket[index], key)
        if previous.next is not None:
            previous.next.value = value  
        else:
            previous.next = self.Node(key, value) 

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        index = self.Hash1(key)
        if self.bucket[index] is None:
            return -1
        previous = self.find(self.bucket[index], key)
        if previous.next is not None:
            return previous.next.value
        return -1

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.Hash1(key)
        if self.bucket[index] is None:
            return
        previous = self.find(self.bucket[index], key)
        if previous.next is not None:
            previous.next = previous.next.next  


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)