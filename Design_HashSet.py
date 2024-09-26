# Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes, after modifying the size to 100000. It passes all the tests for size 100000 and 1000000. Fails with TLE for rest
# Any problem you faced while coding this : Yes, it gave time limit exceeded when size is lesser than the specified limit.
# So the idea is to have a hash of a range of particular size and have a linked list for the range of index. But its only running successfully for size values 100000 and 1000000(max range value mentioned in leetcode question)

# Your code here along with comments explaining your approach

# Linked list node to store keys for each hash index

class Node:
    def __init__(self,key):
        self.key = key
        self.next = None
        
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 100000 # this size needs to be tweaked to make the code efficient
        self.hash_set = [None] * self.size
    
     # function to return the hash index for a range
    def getHash(self,key):
        return key % self.size

    def add(self, key: int) -> None:
        index = self.getHash(key)
        # if index isn't present in hashset then create a new node and return
        if not self.hash_set[index]:
            self.hash_set[index] = Node(key)
            return
        # else get the first node for the index
        currentNode = self.hash_set[index]

        # traverse through the linked list for the index hash
        while currentNode:
            # if key is found return as set should contain unique values
            if currentNode.key == key:
                return
            # else go to the next node
            if currentNode.next:
                currentNode = currentNode.next
        # if key isn't found create new node at the end of linked list
        currentNode.next = Node(key)
        

    def remove(self, key: int) -> None:
        index = self.getHash(key)
        # if nothing to be removed return
        if not self.hash_set[index]:
            return
        # else get the first node for the index hash range list
        current = previous = self.hash_set[index]
        # if first node then make the next node as first, if there is no next node hash range node will be None
        if current.key == key:
            self.hash_set[index] = current.next
            return
        current = current.next
        while current:
            # if key found then make the next variable of previous node point to next of current node
            if current.key == key:
                previous.next = current.next
                return
            # increment both pointers
            previous = previous.next
            current = current.next
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        # get the index hash for range
        index = self.getHash(key)
        node = self.hash_set[index]
        # traverse through the linked list of the index
        while node:
            # if key exists return true
            if node.key == key:
                return True
            node = node.next
        # else return false
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)