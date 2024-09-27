# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# Approach: Using two pointers start and end.. need to redo this using two stacks

class MyQueue:

    def __init__(self):
        self.queue = []
        self.end = -1
        self.start = -1

    def push(self, x: int) -> None:
        self.queue.append(x)
        self.end += 1

    def pop(self) -> int:
        self.start += 1
        return self.queue.pop(0)

    def peek(self) -> int:
        return self.queue[0]

    def empty(self) -> bool:
        if self.start == self.end:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
