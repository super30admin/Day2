# Time complexity: push() - O(1), pop() - O(1) amortized, peek() - O(1) amortized, empty() - O(1)
# Space complexity: O(n) overall for implementation but O(1) per function 
# Running on leetcode: yes
# Class for queue using stacks
class MyQueue(object):
    # Initialization of two stacks
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.instack = []
        self.outstack = []
        
    # Function to push an element into the queue
    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.instack.append(x)
        
    # Function to remove the element from front of queue
    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        self.move()
        return self.outstack.pop()
        
    # Function to return the front element
    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        self.move()
        return self.outstack[-1]
        
    # Function to check if the queue is empty
    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return (not self.instack) and (not self.outstack)
    # Function to move elements from one stack to another to be used in pop and peek   
    def move(self):
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
                
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()