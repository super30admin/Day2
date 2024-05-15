# Time Complexity : Put - O(n), get - O(n), Peek - O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
class MyHashMap: # Implementation with Separate Chaining approach
    class Node: # Represents the nodes of the Linked List
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.buckets = 1000
        self.storage = [None] * self.buckets # Array storage to hold the linked list

    def _get_bucket(self, key): # Hash function for getting the bucket index
        return key % self.buckets

    def _find(self, head, key):
        prev = head
        curr = head.next
        while curr is not None and curr.key != key: # Search for the given key
            prev = curr
            curr = curr.next
        return prev # Return the prev element if the key is found. Else return dummy node

    def put(self, key, value):
        bucket = self._get_bucket(key)
        if self.storage[bucket] is None:
            self.storage[bucket] = self.Node(-1, -1) # If the bucket is empty, create a dummy node
        prev = self._find(self.storage[bucket], key)
        if prev.next is not None:
            prev.next.value = value # update the value if the key is found
        else:
            prev.next = self.Node(key, value) # Else insert the node with the given Key and value

    def get(self, key):
        bucket = self._get_bucket(key)
        if self.storage[bucket] is None: # key is not found
            return -1
        prev = self._find(self.storage[bucket], key)
        if prev.next is not None:
            return prev.next.value # prev.next is current. So returning the current value
        return -1 # Return -1 if not found

    def remove(self, key):
        bucket = self._get_bucket(key)
        if self.storage[bucket] is None: # Return if not found
            return
        prev = self._find(self.storage[bucket], key)
        if prev.next is not None: # Update the previous node pointer to skip the current node (prev.next)
            prev.next = prev.next.next

# Example usage
hash_map = MyHashMap()

# Adding elements
hash_map.put(1, 1)
hash_map.put(2, 2)

# Retrieving elements
print(hash_map.get(1))  # Output: 1
print(hash_map.get(3))  # Output: -1

# Updating an element
hash_map.put(2, 1)
print(hash_map.get(2))  # Output: 1

# Removing an element
hash_map.remove(2)
print(hash_map.get(2))  # Output: -1
