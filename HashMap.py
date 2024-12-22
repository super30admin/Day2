// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not major


// Your code here along with comments explaining your approach

class MyHashMap:
    # Define the ListNode class for linked list nodes
    class ListNode:
        def __init__(self, key: int, value: int):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.size = 1000
        self.bucket = [None] * self.size

    # Hash computation function
    def hashcompute(self, key: int):
        return key % self.size

    # Insert or update key-value pair
    def put(self, key: int, value: int) -> None:
        index = self.hashcompute(key)  # Compute hash index

        if self.bucket[index] is None:  # If no node exists, create one
            self.bucket[index] = self.ListNode(key, value)
        else:
            current = self.bucket[index]
            while True:
                if current.key == key:  # Key already exists, update value
                    current.value = value
                    return
                if current.next is None:  # End of list, insert new node
                    break
                current = current.next
            current.next = self.ListNode(key, value)  # Add new node at end

    # Retrieve value for a key
    def get(self, key: int) -> int:
        index = self.hashcompute(key)
        current = self.bucket[index]

        while current:
            if current.key == key:  # Key found, return value
                return current.value
            current = current.next  # Move to next node

        return -1  # Key not found

    # Remove key-value pair
    def remove(self, key: int) -> None:
        index = self.hashcompute(key)
        current = self.bucket[index]

        if current is None:  # Bucket is empty
            return

        if current.key == key:  # Key is in the head node
            self.bucket[index] = current.next
        else:
            prev = None
            while current:
                if current.key == key:  # Key found, remove it
                    prev.next = current.next
                    return
                prev = current
                current = current.next  # Move to next node
