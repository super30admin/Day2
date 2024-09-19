'''
    Using two stacks, one for pushing elements and the other for popping elements. 
    If stack2 is empty and we want to pop. Move all the elements from stack1 and push into stack2. 
    Push in stack1 regardless and pop the elements from stack2 if present

    Time Complexity: O(1)
    Space Complexity: O(n)
    Ran successfully on Leetcode
'''

class MyQueue:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        if not self.stack2: 
            while self.stack1: 
                val = self.stack1.pop()
                self.stack2.append(val)

        return self.stack2.pop()

    def peek(self) -> int:
        if not self.stack2: 
            while self.stack1: 
                val = self.stack1.pop()
                self.stack2.append(val)

        peekVal = self.stack2.pop()
        self.stack2.append(peekVal)

        return peekVal

    def empty(self) -> bool:
        if not (len(self.stack1)+len(self.stack2)):
            return True

        return False