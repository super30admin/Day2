# Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
# Points to remember: Always check whether the outStack is empty - if yes, then reverse the in stack
# Push should only push elements into the inStack


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inStack.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        # Check if the stack to be popped - reverse of in Stack - is empty and if yes then reverse
        if not self.outStack:
            for i in range(len(self.inStack)):
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.outStack:
            for i in range(len(self.inStack)):
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return (not self.inStack and not self.outStack)
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()