# Time Complexity : O(1)
# Space Complexity :  O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyQueue:

    def __init__(self):
        self.input_stack = []
        self.output_stack = []        

    def push(self, x: int) -> None:
        self.input_stack.append(x)        

    def pop(self) -> int:
        self._transfer()
        return self.output_stack.pop()        

    def peek(self) -> int:
        self._transfer()
        return self.output_stack[-1]        

    def empty(self) -> bool:
        return not self.input_stack and not self.output_stack

    def _transfer(self):
        if not self.output_stack:
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()