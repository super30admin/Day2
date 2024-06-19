## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

## both self.inStack and outStack are such that newest element is at end, ensuring O(1) during pop
## Always push into inStack, when we pop or peek we transer all elements from inStack to outStack, incase outStack is empty.
## If we pop and push alternatively it will not matter since the elements in "front" will get removed first from outStack.

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []
    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        if self.outStack:
            return self.outStack.pop()
        else:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
            return self.outStack.pop()

    def peek(self) -> int:
        if self.outStack:
            return self.outStack[-1]
        else:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
            return self.outStack[-1]


        while self.outStack:
            self.inStack.append(self.outStack.pop())
        return peeked


    def empty(self) -> bool:
        return not self.inStack and not self.outStack



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()