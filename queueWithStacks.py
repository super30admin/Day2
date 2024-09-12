from queue import LifoQueue

# APPROACH : Two-Stack Approach
#DATA STRUCTURE: list
# TIME COMPLEXITY:
                # PUSH:O(1)
                # PEEK:O(N) worst-case
#                   # But the elemnt shifting from the one stack to other stack is not frequently occured.
                # AMORTIZED TIME COMPLEXITY FOR PEEK IS BELOW
                # PEEK:O(1)
                # POP : Same as PEEK WORST CASE: O(N) AMORTIZED COST: O(1)
                # EMPTY: O(1)

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.empty():
            return
        self.peek()
        return self.stack2.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if (self.empty()):
            return
        if (len(self.stack2) > 0):
            return self.stack2[-1]

        else:
            while (len(self.stack1) > 0):
                self.stack2.append(self.stack1.pop())
            return self.stack2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.stack1) == 0 and len(self.stack2) == 0

# APPROACH 2 : Two-Stack Approach
#DATA STRUCTURE: LifoQueue i.e. STACK
# TIME COMPLEXITY:
                # PUSH:O(1)
                # PEEK:O(N) worst-case
#                   # But the elemnt shifting from the one stack to other stack is not frequently occured.
                # AMORTIZED TIME COMPLEXITY FOR PEEK IS BELOW
                # PEEK:O(1)
                # POP : Same as PEEK WORST CASE: O(N) AMORTIZED COST: O(1)
                # EMPTY: O(1)
from queue import LifoQueue


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = LifoQueue()
        self.stack2 = LifoQueue()

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.put(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if (self.empty()):
            return
        self.peek()
        return self.stack2.get()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if (self.empty()):
            return
        if (self.stack2.qsize() > 0):
            value = self.stack2.get()
            self.stack2.put(value)
            return value
        else:
            while (self.stack1.qsize() > 0):
                self.stack2.put(self.stack1.get())
            value = self.stack2.get()
            self.stack2.put(value)
            return value

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return self.stack1.qsize() == 0 and self.stack2.qsize() == 0

# APPROACH 3 : Two-Stack Approach
#DATA STRUCTURE: deque i.e. STACK
# TIME COMPLEXITY:
                # PUSH:O(1)
                # PEEK:O(N) worst-case
#                   # But the elemnt shifting from the one stack to other stack is not frequently occured.
                # AMORTIZED TIME COMPLEXITY FOR PEEK IS BELOW
                # PEEK:O(1)
                # POP : Same as PEEK WORST CASE: O(N) AMORTIZED COST: O(1)
                # EMPTY: O(1)

from collections import deque


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = deque()
        self.stack2 = deque()

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.empty():
            return
        self.peek()
        return self.stack2.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.empty():
            return
        if len(self.stack2) > 0:
            return self.stack2[-1]
        else:
            while len(self.stack1) > 0:
                self.stack2.append(self.stack1.pop())
            return self.stack2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.stack1) == 0 and len(self.stack2) == 0  