class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None
        
class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.mod = 997
        self.hash_set = [None] * self.mod
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = key % self.mod
        
        # If index not present, create a new node
        if self.hash_set[index] == None:
            self.hash_set[index] = ListNode(key)
        
        # If index already present
        # 1. If key present, return
        # 2. If not, create a new node
        else:
            cur = self.hash_set[index]
            # 1. Navigate over te list and Check if key present, then update its value
            while True:
                if cur.key == key:
                    return
                if cur.next == None: break
                cur = cur.next
            # 2. If key not present, append a new node
            cur.next = ListNode(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = key % self.mod
        
        # Kepp track of current and previous node
        cur = prev = self.hash_set[index]
        if not cur: return
        
        # If key found at first position, set the hashmap index to the next node
        if cur.key == key:
            self.hash_set[index] = cur.next
        # Else loop over the remaining nodes
        # If found, link the previous node with the current's next node
        else:
            cur = cur.next
            while cur:
                if cur.key == key:
                    prev.next = cur.next
                    break
                else:
                    cur, prev = cur.next, prev.next

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        index = key % self.mod
        cur = self.hash_set[index]
        # Navigate through all the nodes at a particular index to get the key, return True
        # else return False
        while cur:
            if cur.key == key:
                return True
            else:
                cur = cur.next
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)