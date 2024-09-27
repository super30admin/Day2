// Time Complexity : push O(1), pop O(N), peek O(N), empty O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyQueue:

    def __init__(self):
        self.stack = []
        self.queue = []
        

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        while self.stack :
            self.queue.append(self.stack.pop())
        element = self.queue.pop()
        while self.queue :
            self.stack.append(self.queue.pop())
        return element

    def peek(self) -> int:
        while self.stack :
            self.queue.append(self.stack.pop())
        element = self.queue.pop()
        self.stack.append(element)
        while self.queue :
            self.stack.append(self.queue.pop())
        return element
        

    def empty(self) -> bool:
        if len(self.stack) == 0 :
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
