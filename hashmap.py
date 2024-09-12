 # Time Complexity : O(1) for put, get and remove
 # Space Complexity : O(n)
 # Did this code successfully run on Leetcode : Yes
 # Any problem you faced while coding this : None

 # Implementing hashmap using linkedlists without any built in hashtable library
class Node:
    # initialising an empty node with key, value and next node as arguments
    def __init__(self, key: int, value: int, next = None) -> None:
        self.key = key
        self.value = value
        self.next = next

class MyHashMap:
    # initialising empty hashmap with the size of 10**5, tried using 10**4 but it didn't work for me and showed error in python stating range is low
    def __init__(self):
        self.size = 100000
        self.hashmap = [None] * self.size

    # Function to insert an element into the hashmap using the linkedlist
    def put(self, key: int, value: int) -> None:
        index = key % self.size # hash function
        if self.hashmap[index] is None: # checking if list is empty and if it's empty linkedlist is instantiated orelse new node will be added to the linkedlist
            self.hashmap[index] = Node(key,value)
        else:
            node = self.hashmap[index]
            while node:
                if node.key == key:
                    node.value = value
                    return
                node = node.next
            self.hashmap[index] = Node(key,value,node)

    # Function to return the value of the key
    def get(self, key: int) -> int:
        index = key % self.size
        if self.hashmap[index] is None:
            return -1
        else:
            node = self.hashmap[index]
            while node:
                if node.key == key:
                    return node.value
                node = node.next

            return -1
    # Function to remove the given key,value pair
    def remove(self, key: int) -> None:
        index = key % self.size
        if self.hashmap[index] is None:
            return -1
        else:
            if self.hashmap[index]:
                node = self.hashmap[index]
                if node.key == key:
                    self.hashmap[index] = node.next
                    return
                prev = node
                node = node.next
                while node:
                    if node.key == key:
                        prev.next = node.next
                        return
                    prev = prev.next
                    node = node.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
