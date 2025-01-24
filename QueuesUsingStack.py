# Time Complexity : O(1) for push, pop, peek, and empty operations.
# Space Complexity : O(n) where n is the number of elements in the queue.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No significant issues faced.

# The MyQueue class implements a queue using two stacks. The push operation adds an element to the inStack,
# and the pop operation removes the oldest element from the queue by transferring elements from inStack to outStack.
# The peek operation returns the oldest element without removing it, and the empty operation checks if the queue is empty.

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    def in2out(self):
        while self.inStack:
            self.outStack.append(self.inStack.pop())

    def peek(self) -> int:
        if not self.outStack:
            self.in2out()
        return self.outStack[-1]

    def empty(self) -> bool:
        return not self.inStack and not self.outStack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()