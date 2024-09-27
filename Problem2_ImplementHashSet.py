'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
Email       : pavan1011@gmail.com
S30 SlackID : RN32MAY2021
=================================
'''
'''
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in
the HashSet, do nothing.

Constraints:

- 0 <= key <= 106
- At most 10^4 calls will be made to add, remove, and contains
'''

#-----------------
# Time Complexity: 
#-----------------
# O(N/K): for add(), remove(), and contains(). 
# N is total no. of items, K is no. of buckets.

#------------------
# Space Complexity: 
#------------------
# O(M + K): where M is the size of the buckets and K is the number of buckets 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             : 192 ms (64.34 %ile)
# Space            : 19.3 MB (46.07 %ile) 
# Tradeoff using large keysize (space) and handling many collisions (time)


class MyHashSet:
# Problem is similar to one from Problem 1.py in Design 1.
# Only difference is, we had to store key, value pairs in HashMap,
# only the key in hash set.

# Use 

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # Prime number to support 10^4 calls without too many collissions
        self.max_keysize = 4999
        
        #Buckets to store hash set. Need buckets to handle collision.
        self.hash_set = [[] for i in range(self.max_keysize)]
    
    def hashFunction(self, key):
        return key % self.max_keysize

   
    def add(self, key: int) -> None:
        hashed_index = self.hashFunction(key)
        if self.hash_set[hashed_index]:
            for key_in_hash_set in self.hash_set[hashed_index]:
                if key == key_in_hash_set:
                    return
        
        self.hash_set[self.hashFunction(key)].append(key)

        

    def remove(self, key: int) -> None:
        hashed_index = self.hashFunction(key)
        if self.hash_set[hashed_index]:
            for i in range(len(self.hash_set[hashed_index])):
                if self.hash_set[hashed_index][i] == key:
                    del self.hash_set[hashed_index][i]
                    return

        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashed_index = self.hashFunction(key)
        if self.hash_set[hashed_index]:
            for item in self.hash_set[hashed_index]:
                if item == key:
                    return True

        return False


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)

param_3 = obj.contains(1)
print(param_3)

param_3 = obj.contains(3)
print(param_3)

obj.add(2)

param_3 = obj.contains(2)
print(param_3)

obj.remove(2)

param_3 = obj.contains(2)
print(param_3)