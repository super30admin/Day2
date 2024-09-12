# Time complexity: O(1)
# Space complexity: O(1)

class MyQueue:

    def __init__(self):
        self.in_stack = list()
        self.out_stack = list()
        
    def push(self, x: int) -> None:
        self.in_stack.append(x)

    def pop(self) -> int:
        self.peek()
        if self.out_stack:
            return self.out_stack.pop()
        return

    def peek(self) -> int:
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        
        return self.out_stack[-1]
        

    def empty(self) -> bool:
        return not bool(self.in_stack) and not bool(self.out_stack)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()