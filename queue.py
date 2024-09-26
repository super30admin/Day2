# Time Complexity :
# push :  avg case: O(1) ; Worst case: O(n)
# pop, peek :   avg case: O(1) ; Worst case: O(n) as we'll need to copy S1 stack into S2 stack when S2 is empty

# Space Complexity : O(n), where n is the size of the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach : Using two stacks. All the elements are pushed into first stack. When a pop or peek method is called,
# The elements are popped from the first stack and pushed into second stack simultaneously effectively reversing their order
# then the top element of the second is stack is popped or peeked accordingly.

# // Your code here along with comments explaining your approach

class Stack:

    def __init__(self):
        self.myStack = []

    def isEmpty(self):
        return len(self.myStack) == 0

    def peek(self) -> int:
        if self.isEmpty():
            return None
        return self.myStack[-1]

    def size(self):
        return len(self.myStack)

    def push(self, value):
        self.myStack.append(value)

    def pop(self):
        if self.isEmpty():
            return None
        return self.myStack.pop()


class MyQueue:

    # initializing two stacks
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = Stack()
        self.s2 = Stack()

    # push the elements directly into s1 stack
    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.s1.push(x)

   # pop the elements directly from s2 stack as long as its not empty; if empty copy s1 into s2 and then pop from s2
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.s2.isEmpty():
            while not (self.s1.isEmpty()):
                self.s2.push(self.s1.pop())

        return self.s2.pop()

    # peek the elements directly from s2 stack as long as its not empty; if empty copy s1 into s2 and then peek from s2
    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.s2.isEmpty():
            while not self.s1.isEmpty():
                self.s2.push(self.s1.pop())
        return self.s2.peek()

    # if both stacks are empty then return true
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return (self.s1.isEmpty() and self.s2.isEmpty())
