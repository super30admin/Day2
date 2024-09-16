#Time complexity O(n) -- n is size of the largest linked list.
class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashSet = [None] * 1000
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        keyHash = key % 1000
        if self.hashSet[keyHash] == None:
            newNode = listNode(-1)
            self.hashSet[keyHash] = newNode
        prev = self.hashSet[keyHash]
        while prev.next != None:
            if(prev.next.key == key):
                return
            prev = prev.next
        node = listNode(key)
        prev.next = node

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        keyHash = key % 1000
        if self.hashSet[keyHash] == None:
            return
        prev = self.hashSet[keyHash]
        while prev.next != None:
            if(prev.next.key == key):
                prev.next = prev.next.next
                return 
            prev = prev.next
        return

        
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        keyHash = key % 1000
        if self.hashSet[keyHash] == None:
            return False
        prev = self.hashSet[keyHash]
        while prev.next != None:
            if(prev.next.key == key):
                return True
            prev = prev.next
        return False

class listNode(object):
    def __init__(self, key):
        self.key = key
        self.next = None
        


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(2)
obj.add(4)
obj.add(65)
obj.remove(4)
param_3 = obj.contains(65)
print(param_3)