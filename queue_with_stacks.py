# Time Complexity: O(1)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : It was tricky to code after zeroing down the logic, as I confused between // and %

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = [0]

    def push(self, x: int) -> None:
        size = self.stack2[-1]
        if size > 0:
            top = self.stack1[-1]
            x = top * 10 + x
        self.stack1.append(x)
        self.stack2.append(size + 1)

    def pop(self) -> int:
        top = self.stack1[-1]
        size = self.stack2[-1]
        num = top // 10 ** (size - 1)
        self.stack1[-1] = top % 10 ** (size - 1)
        self.stack2.append(size - 1)
        return num

    def peek(self) -> int:
        size = self.stack2[-1]
        return self.stack1[-1] // 10 ** (size - 1)

    def empty(self) -> bool:
        if len(self.stack1) > 0:
            top = self.stack1[-1]
            if top == 0:
                return True
        elif len(self.stack2) == 1 and self.stack2[0] == 0:
            return True
        return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()