# ------------------------------- Approach 1 - Linear Chaining ----------------------------------------

# Time Complexity : O(n/k) where k is size of hasharray
# Space Complexity : O(k) where k is size of hasharray
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:

# Define a Linked List node
class Node:
    def __init__(self, data = 0):
        self.data = data
        self.next = None

# Define a Linked List class
class LinkedList:

    # Linked List constructor
    def __init__(self):
        self.head = None
    
    # Add new unique data to the Linked List
    def append(self, data):
        # If the data is already present in the Linked List, don't add it
        if self.isPresent(data):
            return
        newnode = Node(data)
        # If there is no head node, then the new node is the head node
        if not self.head:
            self.head = newnode
        # Else append the new node to the end of the Linked List
        else:
            curr = self.head
            while curr.next:
                curr = curr.next
            curr.next = newnode

    # Delete data from the Linked List        
    def delete(self, key):
        # If there is no head node, there is nothing to delete
        if not self.head:
            return
        # If head node contains the key to be deleted, delete it
        if self.head.data == key:
            temp = self.head
            self.head = self.head.next
            temp = None
        # Else find the node that contains the key and delete that node
        else:
            prev = self.head
            curr = prev.next
            while curr:
                if curr.data == key:
                    prev.next = curr.next
                    curr = None
                    break
                prev = curr
                curr = curr.next
    
    # Check if the key is present in the Linked List
    # Iterate through the Linked List, if any node contains the key, then return True, else return False
    def isPresent(self, key):
        curr = self.head
        while curr:
            if curr.data == key:
                return True
            curr = curr.next
        return False

# Define the MyHashSet class        
class MyHashSet1:

    # MyHashSet constructor
    def __init__(self):
        # I randomly chose the size of the hash array to be 907
        self.hasharraysize = 907
        # Create a LinkedList object at each index of the hash array
        self.hasharray = [LinkedList() for i in range(self.hasharraysize)]  

    # Hash Function   
    def _hashfunction(self, key):
        return key % self.hasharraysize    

    # Add a new key to MyHashSet
    def add(self, key: int) -> None:
        # Use the Hash function to calculate the corresponding index of the hash array
        hasharrayindex = self._hashfunction(key)
        # Add the key to the Linked List at the calculated index of the hash array
        self.hasharray[hasharrayindex].append(key)

    def remove(self, key: int) -> None:
        # Use the Hash function to calculate the corresponding index of the hash array
        hasharrayindex = self._hashfunction(key)
        # Delete the key from the Linked List at the calculated index of the hash array
        self.hasharray[hasharrayindex].delete(key)

    def contains(self, key: int) -> bool:
        # Use the Hash function to calculate the corresponding index of the hash array
        hasharrayindex = self._hashfunction(key)
        # Check if the key is present in the Linked List at the calculated index of the hash array
        return self.hasharray[hasharrayindex].isPresent(key)


# -------------------------------- Approach 2 - Double Hashing ----------------------------------------

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Define the MyHashSet class  
class MyHashSet2:

    # MyHashSet Constructor
    def __init__(self):
        self.h1_helper = 1000
        self.h2_helper = 1000
        self.arr = [None]*self.h1_helper
    
    # Hash Function 1
    def getHash1(self, key):
        return key%self.h1_helper
    
    # Hash Function 2
    def getHash2(self, key):
        return key//self.h2_helper

    # If the hash arrays don't contain key, then check if an array already exists at the index of arr given by Hash1.
    # if it exists, then go to the index corresponding to Hash2 and update the value at that index to "True".
    # Else create an array at that index of arr and then go to the index corresponding to Hash2 and update the value at that index to "True".
    def add(self, key: int) -> None:
        if not self.contains(key):
            hash1 = self.getHash1(key)
            if not self.arr[hash1]:
                # Handle edge case of 10^6
                if hash1 == 0:
                    self.arr[hash1] = [False]*(self.h2_helper+1)
                else:
                    self.arr[hash1] = [False]*self.h2_helper
            hash2 = self.getHash2(key)
            self.arr[hash1][hash2] = True
                    
    # Find index of arr by Hash1 and then the calculate corresponding index of the array at tht index of arr and then set the value at that index to False.
    def remove(self, key: int) -> None:
        if self.contains(key):
            hash1 = self.getHash1(key)
            hash2 = self.getHash2(key)
            self.arr[hash1][hash2] = False

    # Calculate hash1 index and check if an array exists at that index of arr. If not, then return False.
    # If the array exists, then calculate hash2 index and return the value in that index. If it is True, the key exists.
    def contains(self, key: int) -> bool:
        hash1 = self.getHash1(key)
        if not self.arr[hash1]:
            return False
        hash2 = self.getHash2(key)
        return self.arr[hash1][hash2]


# hashSet = MyHashSet1()
hashSet = MyHashSet2()
hashSet.add(1)
hashSet.add(2)
print(hashSet.contains(1))
print(hashSet.contains(3))
hashSet.add(2)
print(hashSet.contains(2))
hashSet.remove(2)
print(hashSet.contains(2))