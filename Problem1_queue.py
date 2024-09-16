'''
Time Complexity: O(1)
Space Complexity: O(n)
'''

class MyQueue:

    def __init__(self):
        self.instack = list()
        self.outstack = list()

    def push(self, x: int) -> None:
        self.instack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outstack.pop()

    def peek(self) -> int:
        if self.isEmpty(self.outstack) == 0:
            while self.isEmpty(self.instack) != 0:
                self.outstack.append(self.instack.pop())
        return self.outstack[len(self.outstack) - 1]

    def isEmpty(self, x):
        return len(x)

    def empty(self) -> bool:
        if self.isEmpty(self.instack) == 0 and self.isEmpty(self.outstack) == 0:
            return True
        else:
            return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()