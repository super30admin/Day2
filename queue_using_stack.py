# time complexity O(n)
# space complexity O(n)
class MyQueue:

    def __init__(self):
        self.in_stack = []
        self.out_stack = []
        

    def push(self, x: int) -> None:
        self.in_stack.append(x)   # O(1)
        

    def pop(self) -> int:
        if len(self.out_stack) == 0:
            self.peek()
        return self.out_stack.pop()    # O(1)
        

    def peek(self) -> int:
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())  # O(n)
        return self.out_stack[-1]
        

    def empty(self) -> bool:
        return (len(self.in_stack) == 0) and (len(self.out_stack) == 0) # O(n)
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()