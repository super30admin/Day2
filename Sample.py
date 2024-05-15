#Problem 4
# Time Complexity: O(1) for each individual operation (put, get, remove).
# Space Complexity: O(n) where n is the number of key-value pairs stored in the hashmap.

class MyHashMap:
    def __init__(self):
        self.h = {}  # Initialize an empty dictionary (space complexity: O(1))

    def put(self, key: int, value: int) -> None:
        self.h[key] = value  # Insert or update key-value pair (time complexity: O(1), space complexity: O(1))

    def get(self, key: int) -> int:
        return self.h.get(key, -1)  # Retrieve value for key (time complexity: O(1), space complexity: O(1))

    def remove(self, key: int) -> None:
        if key in self.h:
            del self.h[key]  # Remove key-value pair if key exists (time complexity: O(1), space complexity: O(1))



#problem 5
# Time Complexity: O(1)
# Overall Space Complexity: O(n)

class MyQueue(object):
    def __init__(self):
        self.in_stk = []  # Initialize an empty list to simulate the input stack
        self.out_stk = []  # Initialize an empty list to simulate the output stack
    
    def push(self, x):
        self.in_stk.append(x)  # Push element x to the back of the queue

    def pop(self):
        self.peek()  # Ensure the output stack has the latest elements
        return self.out_stk.pop()  # Remove and return the element from the front of the queue

    def peek(self):
        if not self.out_stk:
            while self.in_stk:
                self.out_stk.append(self.in_stk.pop())  # Transfer elements from input stack to output stack if necessary 
        return self.out_stk[-1]  # Get the front element 

    def empty(self):
        return not self.in_stk and not self.out_stk  # Check if both stacks are empty 


