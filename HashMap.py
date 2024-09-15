"""
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

Time Complexity: O(1) for all operations
Space Complexity: O(n) for all operations
"""


class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.table = [[] for _ in range(self.size)]

    def hash_key(self, key):
        return key % self.size

    def put(self, key, value):
        index = self.hash_key(key)
        for i, (k, v) in enumerate(self.table[index]):
            if k == key:
                self.table[index][i] = (key, value)
                return
        self.table[index].append((key, value))

    def get(self, key):
        index = self.hash_key(key)
        for k, v in self.table[index]:
            if k == key:
                return v
        return -1

    def remove(self, key):
        index = self.hash_key(key)
        for i, (k, v) in enumerate(self.table[index]):
            if k == key:
                del self.table[index][i]
                return


hashmap = MyHashMap()
hashmap.put(1, 1)
hashmap.put(2, 2)
hashmap.put(3, 3)
hashmap.put(2, 1)
print(hashmap.table)
print(hashmap.get(2))
hashmap.remove(2)
print(hashmap.table)
