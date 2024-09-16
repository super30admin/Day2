"""
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

"""
  #Time Complexity : O(1) constant 
  #Space Complexity : O(n)
  #Did this code successfully run on leetcode : Yes
  #Any problem you faced while coding this : None

class MyHashSet:
    
    # initializing a bucket and storage or the hashset of c
    # initial bucket capacity 1000 
    def __init__(self):
        self.capacity = 1000
        self.storage = [[] for i in range(self.capacity)]

    # Using modulo hash function for assigning multiple values to the same bucket
    def bucket(self,key):
        return key%self.capacity 

    # In order to assign multiple values to a single bucket, we uuse the bucket hashfunction
    # We check if the value is already there, then append the next value, else bucket is empty and assign value
    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        if not self.contains(key):
            self.storage[bucket].append(key)

    # To remove the value, we follow same process as adding except at the end we remove the key
    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        if self.contains(key):
            self.storage[bucket].remove(key)

    # Return key if present
    def contains(self, key: int) -> bool:
        bucket = self.bucket(key)
        return key in self.storage[bucket]


s = MyHashSet() 
print(s.add(1))
print(s.add(2))
print(s.contains(1))
print(s.contains(3))
print(s.add(2))
print(s.contains(2))
print(s.remove(2))