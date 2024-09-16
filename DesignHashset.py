# Time Complexity for 'add', 'contains' and 'remove' is O(1)
# Space Complexity is O(n)
class Node(object):
    def __init__(self,val):
        self.val = val
        self.next = None
class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset = [None]*(10**4)

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = hash(key) % (10**4)
        if self.hashset[index] is None:
            self.hashset[index] = Node(key)
            return
        curr = self.hashset[index]
        while(curr.next):
            if(curr.val == key):
                return
            curr = curr.next
        if(curr.val == key):
            return
        curr.next = Node(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = hash(key)%(10**4)
        curr = self.hashset[index]
        if curr is None:
            return
        elif(curr.val == key):
            self.hashset[index] = curr.next
        while(curr.next):
            if(curr.next.val == key):
                curr.next = curr.next.next
                return
            curr = curr.next

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        index = hash(key)%(10**4)
        curr = self.hashset[index]
        if curr is None:
            return False
        while(curr):
            if(curr.val == key):
                return True
            curr=curr.next
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)