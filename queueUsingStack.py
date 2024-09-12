# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        #append to the end of the list
        self.stack.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        #pop element at index 0
        return self.stack.pop(0)

    def peek(self) -> int:
        """
        Get the front element.
        """
        #return element at index 0
        return self.stack[0]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.stack)==0:
            return True
        return False


queue = MyQueue()
queue.push(1)
queue.push(2)  
print(queue.peek())  # returns 1
print(queue.pop())   # returns 1
print(queue.empty()) # returns false