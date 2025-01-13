"""
https://leetcode.com/problems/design-hashmap/description/
leetcode #706 Design Hashmap
"""


"""
Brute Force Approach: In this approach I will create a List (Array) of size 10^6 +1 so that it will accomodate values from index 0 to 10^6. I will create a hash function key % 10^6 ( which will give me values between 0 to 10^6) and using that I will store values at that location in the array. And since its array and we will get "Random access" its complexity of get operation would be O(1)
Time Complexity: O(1)
Space Complexity: O(1) its constanat and in worst case it would be 10^6+1
"""


class MyHashMapBruteForceApproach:

    def __init__(self):
        self.size = 10**6
        # array of size 10^6 + 1 all initialize to  -1
        self.hashmap = [-1] * (self.size + 1)

    def hashFunction(self, key: int) -> int:
        return key % self.size

    def put(self, key: int, value: int) -> None:
        index = self.hashFunction(key)

        # insert value at that position in the hash map
        self.hashmap[index] = value

    def get(self, key: int) -> int:
        index = self.hashFunction(key)
        return self.hashmap[index]

    def remove(self, key: int) -> None:
        index = self.hashFunction(key)
        self.hashmap[index] = -1


# Optimized approach using double hasing.
"""
In this approach, I will reduce the sie of array to 10^3+1 to get the values between 0 to 10^3  in first hashing function key % 10^3+1. Now first hashing will give you value in the first array and then second hash function will give you value in the second array. second hash will be key // 10^3+1
array will store the value.
Time Complexity: O(1)
Space Complexity: O(1) but certainly improved that first approach.
"""


class MyHashMapOptimizedApproach1:

    def __init__(self):
        self.size = 10**3+1
        self.hashmap = [None] * self.size  # array of size 10^3 + 1

    def fisrtHash(self, key: int) -> int:
        return key % self.size  # return value between 0 to 10^3

    def secondHash(self, key: int) -> int:
        return key // self.size

    def put(self, key: int, value: int) -> None:

        # get the index in first array
        first_index = self.fisrtHash(key)
        # get index in second array
        second_index = self.secondHash(key)

        # check if array is available at first_index
        if not self.hashmap[first_index]:
            # secodary array is not available
            # need to define the secondary array
            self.hashmap[first_index] = [-1] * self.size

        # insert value at second_index
        self.hashmap[first_index][second_index] = value

    def get(self, key: int) -> int:

        # get the index in first array
        first_index = self.fisrtHash(key)
        # get index in second array
        second_index = self.secondHash(key)

        # check if array is available at sceondary index
        if not self.hashmap[first_index]:
            return -1

        # return value
        return self.hashmap[first_index][second_index]

    def remove(self, key: int) -> None:

        # get the index in first array
        first_index = self.fisrtHash(key)
        # get index in second array
        second_index = self.secondHash(key)

        if not self.hashmap[first_index]:
            return

        # remove key by replaceing it with default value
        self.hashmap[first_index][second_index] = -1


# Further Optimized approach using double hasing.
"""
Same as above, but instead of creating secondary array of size 10^3 + 1 everytime, its required only at index 0. because largest possible value is 10^6 and 1000000 % 1000 is 0, so only at index zero we have key 10^6 and second hash 10^6 // 10^3 is 10^3 so only at index 0 we need secondary array of size 10^3 + 1 to store value at 10^3 th position otherwise, array of size 10^3 works
Time Complexity: O(1)
Space Complexity: O(1) but certainly improved that first approach.
"""


class MyHashMapOptimizedApproach2:

    def __init__(self):
        self.size = 10**3+1
        # array of size 10^3 + 1 ( values: 0 to 10^3)
        self.hashmap = [None] * self.size

    def fisrtHash(self, key: int) -> int:
        return key % self.size   # return value between 0 to 10^3

    def secondHash(self, key: int) -> int:
        return key // self.size

    def put(self, key: int, value: int) -> None:

        # get the index in first array
        first_index = self.fisrtHash(key)
        # get index in second array
        second_index = self.secondHash(key)

        # check if array is available at first_index
        if not self.hashmap[first_index]:
            # secodary array is not available
            # need to define the secondary array
            if first_index == 0:
                # array of size 10^3 + 1 to have index 10^3
                self.hashmap[first_index] = [-1] * self.size
            # for all other index array of size 10^3 works which will store value from 0 to 999
            self.hashmap[first_index] = [-1] * (self.size - 1)

        # insert value at second_index
        self.hashmap[first_index][second_index] = value

    def get(self, key: int) -> int:

        # get the index in first array
        first_index = self.fisrtHash(key)
        # get index in second array
        second_index = self.secondHash(key)

        # check if array is available at sceondary index
        if not self.hashmap[first_index]:
            return -1

        # return value
        return self.hashmap[first_index][second_index]

    def remove(self, key: int) -> None:

        # get the index in first array
        first_index = self.fisrtHash(key)
        # get index in second array
        second_index = self.secondHash(key)

        if not self.hashmap[first_index]:
            return

        # remove key by replaceing it with default value
        self.hashmap[first_index][second_index] = -1


# Liner chaining Approach
"""
In this approach instead of creating a secondary array, I will create a linked list. I will define the class Liked List with 3 operations (append, find, delete)
"""


class Node:
    # Class for Node in single Linked List
    def __init__(self, data: int, value: int):
        self.data = data  # Store the key
        self.value = value  # Store the value
        self.next = None  # Initialize the next pointer as None


class LinkedList:
    # Class for Linked List
    def __init__(self):
        self.head = None  # Initialize the head of the list as None

    def append(self, data, value) -> None:
        # Insert Node in the linked list
        new_node = Node(data, value)

        if not self.head:
            # Linked list is empty; assign head to this current node
            self.head = new_node
            return
        else:
            # List is not empty
            current = self.head
            # Iterate to the last node where `current.next` is None
            while current.next:
                current = current.next
            # Now `current` is at the last Node
            current.next = new_node

    def find(self, data) -> int:
        # Check if the linked list is empty
        if not self.head:
            return -1  # Return -1 if empty

        current = self.head

        while current:
            if current.data == data:
                # Node found; return its value
                return current.value
            current = current.next  # Move to the next node

        return -1  # Key is not present in the linked list

    def delete(self, data) -> None:
        # Check if the linked list is empty
        if not self.head:
            return  # Nothing to delete

        # If the head node is the node to delete
        if self.head.data == data:
            self.head = self.head.next
            return

        current = self.head
        while current.next and current.next.data != data:  # Traverse to the node before the target
            current = current.next

        if current.next:  # If the target node is found
            # Delete the node
            current.next = current.next.next


class MyHashMap:
    # Class for HashMap
    def __init__(self):
        self.size = 10**3 + 1
        # Array of size 10^3 + 1 (values: 0 to 10^3)
        self.hashmap = [None] * self.size

    def firstHash(self, key: int) -> int:
        # Hash function to get index in the hashmap
        return key % self.size

    def put(self, key: int, value: int) -> None:
        # Get the index using the hash function
        index = self.firstHash(key)

        if not self.hashmap[index]:
            # If no linked list exists, create a new one
            self.hashmap[index] = LinkedList()

        # Check if the key is already present in the linked list
        existing_value = self.hashmap[index].find(key)
        if existing_value != -1:
            # If the key exists, delete the existing node first
            self.hashmap[index].delete(key)

        # Append the new key-value pair to the linked list
        self.hashmap[index].append(key, value)

    def get(self, key: int) -> int:
        # Get the index using the hash function
        index = self.firstHash(key)

        if not self.hashmap[index]:
            # If no linked list exists, the key is not present
            return -1

        # Search for the key in the linked list and return its value
        return self.hashmap[index].find(key)

    def remove(self, key: int) -> None:
        # Get the index using the hash function
        index = self.firstHash(key)

        if self.hashmap[index]:
            # If a linked list exists, delete the key from it
            self.hashmap[index].delete(key)
