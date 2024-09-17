'''
I have used the chaining method as the hashing strategy.
I used modulo operator as the hashing function and used LinkedList as the Bucket DS
I have used a prime number as the keyRange since it makes the collision strategy more stronger.
'''


class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.keyRange = 2069
        self.bucketArray = [Bucket() for i in range(self.keyRange)]

    def getHash(self, key):
        return key % self.keyRange

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucketIndex = self.getHash((key))
        self.bucketArray[bucketIndex].insert(key)
        # print("Inserted: ", key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucketIndex = self.getHash(key)
        self.bucketArray[bucketIndex].delete(key)
        # print("Removed: ", key)

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        bucketIndex = self.getHash(key)
        # print(key, "present or not?: ", self.bucketArray[bucketIndex].exists(key))


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Bucket:
    def __init__(self):
        self.head = Node(0)

    def insert(self, val):
        if not self.exists(val):
            newNode = Node(val)
            self.head.next = newNode

    def delete(self, val):
        prev = self.head
        curr = self.head.next
        while curr is not None:
            if curr.data == val:
                prev.next = curr.next
                return
            prev = curr
            curr = curr.next

    def exists(self, val):
        curr = self.head.next
        while curr is not None:
            if curr.data == val:
                return True
            curr = curr.next
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)