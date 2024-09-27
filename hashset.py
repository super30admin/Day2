# Create a list of constant size
# Get hashed valued by taking mod of key and size of list

# In put, check whether the hashed value exists in the list or not
# If it does not, add a new Node with key as key
# If it does exist, then traverse till we find the key and do nothing
# If the key does not exist then add it at the end of the linked list for that hash

# To contains, calculate hashed value of the key
# If hashed valued exists in the list, iterate through the linked list till we find the key
# If key found, return True
# Else return False

# To remove, we will check whether the hashed value exists in the list or not
# If it does, we will check whether if it exists at the head
# If it does, we will point the fist node to current's next
# Else we will iterate till we find the key by keeping two pointers, prev and current
# If key found, change the prev.next to current.next

# Time Complexity: Worst Case: O(n) Too many collisions, Average Case: O(1)
# Space Complexity: O(n)

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

class MyHashSetDoubleHashing(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.hashSet = [None] * self.size
        
    def __hashingOne(self, key):
        return key % self.size
    
    def __hashingTwo(self, key):
        return key // self.size
    
    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        h1 = self.__hashingOne(key)
        h2 = self.__hashingTwo(key)
        if not self.hashSet[h1]:
            self.hashSet[h1] = [False] * self.size
            self.hashSet[h1][h2] = True
        else:
            self.hashSet[h1][h2] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        h1 = self.__hashingOne(key)
        h2 = self.__hashingTwo(key)
        if self.hashSet[h1]:
            self.hashSet[h1][h2] = False
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        h1 = self.__hashingOne(key)
        h2 = self.__hashingTwo(key)
        if self.hashSet[h1]:
            return self.hashSet[h1][h2]
        else:
            return False

print('LINEAR CHAINING')
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

print('DOUBLE HASHING')
hashSet = MyHashSetDoubleHashing()
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