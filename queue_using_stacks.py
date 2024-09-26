# Time Complexity : O(1)
# Space Complexity : O(logn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MyQueue:

    def __init__(self):
        self.queue1 = []
        self.queue2 = []
        

    def push(self, x: int) -> None:
        self.queue1.append(x)
        

    def pop(self) -> int:
        if not self.queue2:
            while self.queue1:
                self.queue2.append(self.queue1.pop())
        return self.queue2.pop()
        

    def peek(self) -> int:
        if not self.queue2:
            while self.queue1:
                self.queue2.append(self.queue1.pop())
        return self.queue2[-1]
        

    def empty(self) -> bool:
        return self.queue1 == [] and self.queue2 == []
