"""
232. Implement Queue using Stacks
Time Complexity-
Push - O(1)
Pop - O(1) in most of the cases
Peek - O(1) in most of the cases
empty -O(1)
Space Complexity - O(n)
"""
class MyQueue:
    def __init__(self):
        self.pushstack = []
        self.pushpopstack = []
        

    def push(self, x: int) -> None:
        self.pushstack.append(x)
        

    def pop(self) -> int:
        if self.empty():
            return None
        if len(self.pushpopstack) == 0:
            while len(self.pushstack) > 0:
                self.pushpopstack.append(self.pushstack.pop())

        return self.pushpopstack.pop()

    def peek(self) -> int:
        if self.empty():
            return None
        
        if len(self.pushpopstack) == 0:
            while len(self.pushstack) > 0:
                self.pushpopstack.append(self.pushstack.pop())
        return self.pushpopstack[-1]      

    def empty(self) -> bool:
        return not(len(self.pushstack) or len(self.pushpopstack))
