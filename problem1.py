# Time Complexity :
#   Push: O(1)
#   Pop: O(n)
#   peek: O(n)
#   empty:O(1)
# Space Complexity:
#     O(n)
#  Did this code successfully run on Leetcode : Yes

class MyQueue:

    def __init__(self):
        self.primaryStack = []
        self.secondaryStack = []

    def push(self, x: int) -> None:
        self.primaryStack.append(x)

    def pop(self) -> int:
        if len(self.secondaryStack) == 0:
            if len(self.primaryStack) == 0:
                return
            else:
                while len(self.primaryStack) != 0:
                    self.secondaryStack.append(self.primaryStack.pop())
        return self.secondaryStack.pop()

    def peek(self) -> int:
        if len(self.secondaryStack) == 0:
            if len(self.primaryStack) == 0:
                return
            else:
                while len(self.primaryStack) != 0:
                    self.secondaryStack.append(self.primaryStack.pop())
        return self.secondaryStack[len(self.secondaryStack) - 1]

    def empty(self) -> bool:
        return len(self.primaryStack) == 0 and len(self.secondaryStack) == 0

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
