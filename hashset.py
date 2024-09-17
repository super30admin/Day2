class Node(object):
    
    def __init__(self, key):
        self.key = key
        self.next = None
        

class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.hashset = [None] * self.size
        
        
    def hashing(self, key):
        return key % self.size
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        hashed = self.hashing(key)
        if self.hashset[hashed]:
            current = self.hashset[hashed]
            while current:
                if current.key == key:
                    return
                elif current.next is None:
                    break
                current = current.next
            current.next = Node(key)
        else:
            self.hashset[hashed] = Node(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hashed = self.hashing(key)
        if self.hashset[hashed]:
            prev, current = self.hashset[hashed], self.hashset[hashed]
            if not current:
                return
            elif current.key == key:
                self.hashset[hashed] = current.next
            else:
                current = current.next
                while current:
                    if current.key == key:
                        prev.next = current.next
                        break
                    prev, current = prev.next, current.next
            
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        hashed = self.hashing(key)
        if self.hashset[hashed]:
            current = self.hashset[hashed]
            while current:
                if current.key == key:
                    return True
                current = current.next
        return False


hashSet = MyHashSet()
hashSet.add(1)         
hashSet.add(2)         
print(hashSet.contains(1))
# // returns true
print(hashSet.contains(3))
# // returns false (not found)
hashSet.add(2)          
print(hashSet.contains(2))
# // returns true
hashSet.remove(2)          
print(hashSet.contains(2))
# // returns false (already removed)