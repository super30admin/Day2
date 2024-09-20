"""
This program designs the hash map using chaining method for collisions. It implements following hash map methods:
get the value for a key, search the key and remove the key
"""


class Node:
    def __init__(self, key, val):
        """
        Initialize the Linked list node with key value pair.
        :param key: key to stored in hash map
        :param val: value associated with the key
        """
        self.next = None
        self.val = val
        self.key = key


class MyHashMap:

    def __init__(self):
        """
        Initialize the hash map with default values.
        the data structure is: array of Nodes with size 1000.
        the max value each bucket can hold is 100.
        """
        self.bucket_size = 1000
        self.array_bucket = [None for _ in range(self.bucket_size)]

    def get_hash_code(self, key):
        """
        This function calculates the hash code for given key
        :param key: key to find the respective hash code
        :return: hash code for the key
        Takes O(1) time
        """
        return key % self.bucket_size

    def get_previous_node(self, node, key):
        """
        This method finds the previous node of a given node in hash map.
        The idea to make the code modular, since previous node can used in all three methods (add, get and remove)
         of hash map
        :param node: node whose previous node we want to find out.
        :param key: key to check if curr node is the one whose previous node we want to find out
        :return: previous node
        Takes O(1) times. Eve
        """
        prev = node
        curr = prev.next
        while curr:
            if curr.key == key:
                return prev
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        """
        This method (1) check if bucket is initialized. if not create a dummy node and add make it head.
        (2) find the previous key where the new key needs to be added.
        (3) Two cases happens: the key is present then update and if key not present add it to end.
        The previous key is last if key is not present, create a new node and add. If key exists the next node to
        previous won't be null, update the key's value.

        :param key: add key to the hash map
        :param value: add corresponding value to hash map
        :return: None
        Takes O(1) time
        """
        hash_code = self.get_hash_code(key)
        if self.array_bucket[hash_code] is None:
            self.array_bucket[hash_code] = Node(-1, -1)

        head = self.array_bucket[hash_code]
        prev = self.get_previous_node(head, key)
        curr = prev.next
        if curr:
            curr.val = value
        else:
            new_node = Node(key, value)
            prev.next = new_node

    def get(self, key: int) -> int:
        """
        This method finds the value associated with the given key.
        Same as put() 2 cases possible.
        :param key: key whose value we want to find
        :return: value of the key associated with the given key
        Takes O(1) time
        """
        hash_code = self.get_hash_code(key)
        if self.array_bucket[hash_code] is None:
            return -1
        head = self.array_bucket[hash_code]
        prev = self.get_previous_node(head, key)
        curr = prev.next
        if curr:
            return curr.val
        else:
            return -1

    def remove(self, key: int) -> None:
        """
        This method removes the value associated with the given key.
        Two cases possible: key not present and present.
        :param key: key to be removed from the hash map
        :return: None
        Takes O(1) time
        """
        hash_code = self.get_hash_code(key)
        head = self.array_bucket[hash_code]
        if self.array_bucket[hash_code] is None:
            return
        prev = self.get_previous_node(head, key)
        curr = prev.next
        if curr:
            prev.next = curr.next


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1, 3)
# param_2 = obj.get(key)
# obj.remove(key)
