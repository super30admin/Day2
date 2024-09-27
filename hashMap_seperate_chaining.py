# Time Complexity: O(1)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None


class MyHashMap:
    def __init__(self):
        self.bucketSize = 100
        self.bucket = [None] * 10000

    def get_bucket_id(self, key):
        return key % 10000

    def put(self, key, value):
        bucket_id = self.get_bucket_id(key)

        # bucket is not initialized
        if not self.bucket[bucket_id]:
            self.bucket[bucket_id] = Node(-1, -1)
            self.bucket[bucket_id].next = Node(key, value)
        else:
            prev = self.find(key)
            # reached the end of linked list
            if prev.next is None:
                prev.next = Node(key, value)
            # found the node
            else:
                prev.next.val = value

    def find(self, key):
        bucket_id = self.get_bucket_id(key)

        prev = self.bucket[bucket_id]
        if prev is None:
            return None
        else:
            current = prev.next
            while current is not None and current.key != key:
                prev = prev.next
                current = current.next
            return prev

    def remove(self, key):
        prev = self.find(key)
        # linkedlist is not initialized
        if prev is None:
            return
        # reached end of the linkedlist
        elif prev.next is None:
            return
        else:
            temp = prev.next
            prev.next = prev.next.next
            temp = None

    def get(self, key):
        node = self.find(key)
        # linkedlist is not initialized
        if node is None:
            return -1
        # reached end of the linkedlist
        elif node.next is None:
            return -1
        else:
            return node.next.val
