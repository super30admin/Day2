from collections import deque

# Approach #1: Late push, quick pop
""" 
class MyQueue:

    def __init__(self):

        #Initialize your data structure here.

        self.stack1 = deque()
        self.stack2 = deque()
        self.top = float('inf')

    def push(self, x: int) -> None:

        #Push element x to the back of queue.

        if not self.stack1:
            self.top = x

        while self.stack1:
            self.stack2.appendleft(self.stack1.popleft())
        self.stack2.appendleft(x)

        while self.stack2:
            self.stack1.appendleft(self.stack2.popleft())


    def pop(self) -> int:

        #Removes the element from in front of queue and returns that element.

        result =  self.stack1.popleft()
        if self.stack1:
            self.top = self.stack1[0]
        else:
            self.top = float('inf')
        return result

    def peek(self) -> int:

        #Get the front element.

        return self.top

    def empty(self) -> bool:

        #Returns whether the queue is empty.

        return not self.stack1
"""


# Approach #2: Late pop, quick push
class MyQueue:

    def __init__(self):
        """
        #Initialize your data structure here.
        """
        self.stack1 = deque()
        self.stack2 = deque()
        self.top = float('inf')

    def push(self, x: int) -> None:
        """
        #Push element x to the back of queue.
        """
        if not self.stack1:
            self.top = x

        self.stack1.appendleft(x)

    def pop(self) -> int:
        """
        #Removes the element from in front of queue and returns that element.
        """
        if not self.stack2:
            while self.stack1:
                self.stack2.appendleft(self.stack1.popleft())

        return self.stack2.popleft()

    def peek(self) -> int:
        """
        #Get the front element.
        """
        if self.stack2:
            return self.stack2[0]
        return self.stack1[-1]

    def empty(self) -> bool:
        """
        #Returns whether the queue is empty.
        """
        return not self.stack1 and not self.stack2

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

"""
# Approach 1:
    Space Complexity: O(n) 
    Time Complexity:
    push: O(n) 
    pop: O(1) 
    peek: O(1)
    Empty: O(1)
# Approach 2:
    Space Complexity: O(n) 
    Time Complexity:
    push: O(1) 
    pop: O(n) worst case, O(1) Amortized
    peek: O(1)
    Empty: O(1)
"""