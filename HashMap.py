# Time Complexity : 
    # put: O(1) on avergae, because the find function is traversing the LL
    # remove: O(1) 
    # get: O(1)
# Space Complexity : O (n + m), n is the number of nodes, m is the number of buckets/length of the bucket list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No, all good.

# Your code here along with comments explaining your approach:
   # used separate chaining technique
    # initialized a bucket array of nodes
    # then getIndex based on a hash function, next we will check if a list already exists at that bucket/index
    # if not, will add a dummy node before starting the list, so that the remove function can be done with the prior node
    # next, find dunction will traverse through the list to see if the key exists in the list already or not
    # if prev.next is None, then it means the key does not exist and we add a new node at prev.next
    # if the key exists, we can then perform get and remove functions similarly

class MyHashMap(object):
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def getBucket(self, key):
        return key % self.buckets

    def find(self, dummy, key):
        prev = dummy
        current = dummy.next

        while current is not None and current.key != key:
            prev = current
            current = current.next
        
        return prev

    def __init__(self):
        self.buckets = 1000
        self.storage = [None] * self.buckets  # array of nodes

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        bucket = self.getBucket(key)
        if self.storage[bucket] is None:
            # this means that the bucket is empty
            # so we initialize with a dummy node
            self.storage[bucket] = self.Node(-1, -1)

        prev = self.find(self.storage[bucket], key)
        
        if prev.next is None:
            # this means that the key does not exist
            # so create a new node
            prev.next = self.Node(key, value)
        else:
            # this means that the key already exists
            # updating the value for the next node
            prev.next.value = value

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        bucket = self.getBucket(key)
        if self.storage[bucket] is None:
            # bucket is empty at this index, key does not exist
            return -1

        prev = self.find(self.storage[bucket], key)
        if prev.next is None:
            # key not found
            return -1
        else:
            # key is found at the next index
            return prev.next.value

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getBucket(key)
        if self.storage[bucket] is None:
            # bucket is empty, do nothing
            return

        prev = self.find(self.storage[bucket], key)
        if prev.next is None:
            # key is not found, do nothing
            return
        else:
            # removing the next node
            prev.next = prev.next.next
