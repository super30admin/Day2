# Approach:  To avoid collision the following can be implemented
# Choose a large prime number as the hashing key
# The primary data type used is array in which we bucket the elements into buckets (indexed at indexes calculated by hash function) created with the data type Linked lists
# Here, arrays can also be chosen but we know that we only get O(N) complexities if we need to insert/delete elements in array, the same can be done in O(1) complexities for Linked lists
# Time Complexity: O(M/N) where M is the number of elements inserted at N buckets
# Space Complexity: O(M + N) 
# Constraint: As discussed in class, we could do much better than LL as well, since searching through LL is O(N) -- We could opt for BST since it results in O(log(N)) complexity
# Successfully ran on leetcode
# Any issues: Had issues with designing hash map in  Design -1 assignment, after the class it was clearer how we would optimize from using an array

class MyHashSet():
    def __init__(self):
        self.hash_key = 239
        self.hashSet = [LinkedList() for val in range(self.hash_key)]


    def _hash(self,key):
        index = key % self.hash_key
        return index

    def add(self, key):
        hash_index = self._hash(key)
        self.hashSet[hash_index].insert(key)

    def remove(self, key):
        hash_index = self._hash(key)
        self.hashSet[hash_index].delete(key)

    def contains(self, key):
        hash_index = self._hash(key)
        return self.hashSet[hash_index].exists(key)


class Node():
    def __init__(self, data, next=None):
        self.data = data
        self.next = None


class LinkedList():

    def __init__(self):
        # Setting a pre head will help when we want to insert elements into LL at the head positions and not tails
        self.prehead = Node(None) 


    # Check if it exists, return True else None
    def exists(self, key):
        current_element = self.prehead.next
        while current_element is not None:
            if current_element.data == key:
                return True
            else:
                current_element = current_element.next

        return None


    # Check first if the val exists in the LL, if not insert as the head to the LL so it is easier when we need to search for this element
    def insert(self, key):
        check_for_node = self.exists(key)
        if check_for_node is None:
            new_node = Node(key)
            new_node.next = self.prehead.next
            self.prehead.next = new_node

    # Similar to LL 'delete' functionality, if element is never found return None
    def delete(self, key):
        prev = self.prehead
        current = self.prehead.next
        while current is not None:
            if current.data == key:
                prev.next = current.next
                break
            prev = current
            current = current.next  

        return None


