# Time Complexity :
# O(n) for findNode(), put(), get((), remove()


# Space Complexity : 
# O(n), since the linkedList attached to each index 
# in primary array will grow according to different key received


# Approach:
# Create a primary array of length = squareroot(maximum number of keys in constraints)
# Then use hashing function to find the primaryIndex of given key
# Then, at that index, initialize a dummy Node that serves as the start of linkedList
# this LinkedList will store all different key-value pairs, after 
#  evaluating the hash of the key, and then traversing the linkedlist to update or insert new pair

# Implement using Separate Chaining approach
class MyHashMap: 
    # A Node to store key-value pair
    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.bucket = 1000     # sqaure root of 10E6 which is max value of key
        self.primaryIndexArray = [None] * self.bucket

    def findNode(self, dummy, key) -> Node:
        prev = dummy
        curr = prev.next
        while (curr is not None and curr.key != key):
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        # get the index of the key in primary array of length 1000 we created in constructor
        bucketIndex = key % 1000

        if self.primaryIndexArray[bucketIndex] is None:
            # initialze dummy node for the LinkedList at this index
            self.primaryIndexArray[bucketIndex] = self.Node(-1, -1)

        # find the node with given key
        prev = self.findNode(self.primaryIndexArray[bucketIndex], key)
        if (prev.next is not None):
            prev.next.val = value
        else:
            prev.next = self.Node(key, value)

    def get(self, key: int) -> int:
        # get the index of the key in primary array
        bucketIndex = key % 1000

        if self.primaryIndexArray[bucketIndex] is None:
            # this means key is not present , hence return -1
            return -1
        prev = self.findNode(self.primaryIndexArray[bucketIndex], key)
        if (prev.next ):
            return prev.next.val
        else:
            return -1

    def remove(self, key: int) -> None:
        # get the index of the key in primary array
        bucketIndex = key % 1000

        if self.primaryIndexArray[bucketIndex] is None:
            # this means key is not present , hence return 
            return
        prev = self.findNode(self.primaryIndexArray[bucketIndex], key)
        if (prev.next ):
            prev.next = prev.next.next