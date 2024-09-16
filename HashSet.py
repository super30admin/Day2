# Time Complexity : O(N)

# Space Complexity : O(N)

# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# I have used LinkedList with chaining to implement HashSet


class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.data = [None] * self.size

    def add(self, key: int) -> None:
        index = key % self.size
        if self.data[index] == None:
            self.data[index] = ListNode(key, True)
        else:
            currentNode = self.data[index]
            temp = currentNode
            self.data[index] = ListNode(key, True)
            self.data[index].next = currentNode

    def remove(self, key: int) -> None:
        index = key % self.size

        if self.data[index] == None:
            return
        else:
            currentNode = self.data[index]
            while currentNode:
                if currentNode.key == key:
                    currentNode.val = False
                currentNode = currentNode.next

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index = key % self.size

        if self.data[index] == None:
            return False
        else:
            currentNode = self.data[index]
            while currentNode:
                if currentNode.key == key:
                    if currentNode.val == True:
                        return True
                currentNode = currentNode.next
            return False


class ListNode():
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)