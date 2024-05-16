# Time Complexity :

# find: O(n)
# put: O(n)
# get: O(n)
# remove: O(n)


# space complexity : O(n)

# Approach :

# calculate the bucket index based on the modulo operation
# maintain two pointers, current and previous.
# while pushing, if bucket is empty, first push (-1,-1), as the base node, and keep appending new elements by changing prev.next or if the key is present already, just update the value
# while finding a value based on the key, if current becomes none, then the key isnt present, else present
# while removing a value based on the key, if current becomes none, then the key isnt present, else present, then in that case make prev.next=prev.next.next and delete the node which needs to be removed by removing its link with the next link

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        self.bucket = 10000
        self.storage = [None]*self.bucket

    def getBucket(self, key):
        return key % self.bucket

    def find(self, tempNode, key):
        prevNode = tempNode
        currNode = tempNode.next

        while (currNode != None and currNode.key != key):
            prevNode = currNode
            currNode = currNode.next

        return prevNode

    def put(self, key: int, value: int) -> None:

        bucketIndex = self.getBucket(key)
        if (self.storage[bucketIndex] == None):
            self.storage[bucketIndex] = Node(-1, -1)

        prevNode = self.find(self.storage[bucketIndex], key)

        if (prevNode.next != None):
            prevNode.next.value = value

        else:
            prevNode.next = Node(key, value)

    def get(self, key: int) -> int:

        bucketIndex = self.getBucket(key)
        if (self.storage[bucketIndex] == None):
            return -1

        prevNode = self.find(self.storage[bucketIndex], key)

        if (prevNode.next != None):
            return prevNode.next.value

        return -1

    def remove(self, key: int) -> None:

        bucketIndex = self.getBucket(key)
        if (self.storage[bucketIndex] == None):
            return

        prevNode = self.find(self.storage[bucketIndex], key)

        if (prevNode.next != None):
            deleteNode = prevNode.next
            prevNode.next = prevNode.next.next
            deleteNode.next = None

        else:
            return
