"""
Time Complexity: O(1) for all operations
"""

class MyQueue:

    def __init__(self):
        self.q_stack = []
        self.temp_stack = []

    def push(self, x: int) -> None:
        self.q_stack.append(x)
        print(self.q_stack)

    def pop(self) -> int:
        front = None

        while self.q_stack:
            if len(self.q_stack) == 1:
                front = self.q_stack[-1]
                self.q_stack.pop()
                break
            popped = self.q_stack.pop()
            self.temp_stack.append(popped)

        while self.temp_stack:
            popped = self.temp_stack.pop()
            self.q_stack.append(popped)

        print(self.q_stack)
        return front

    def peek(self) -> int:
        peek_val = None
        while self.q_stack:
            if len(self.q_stack) == 1:
                peek_val = self.q_stack[-1]
                break
            popped = self.q_stack.pop()
            self.temp_stack.append(popped)

        while self.temp_stack:
            popped = self.temp_stack.pop()
            self.q_stack.append(popped)

        print(self.q_stack)
        return peek_val

    def empty(self) -> bool:
        print(self.q_stack)
        return False if self.q_stack else True


queue = MyQueue()
queue.push(1)
queue.push(2)
print(queue.peek())
print(queue.pop())
print(queue.empty())
