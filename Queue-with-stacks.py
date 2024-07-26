
# Amortised time complexity = O(1)
# space complexity - O(n)
# executed on Leetcode
# Using two stacks
# everytime an element arrives its added to push_stask
# everytime a pop happens and pop_stack is empty all elements from push_stack are popped and added to push_stack
# subsequent pops happen from pop_stack in O(1) till pop_stack is empty
# peek points to last element in pop_stack and first element in push_stack
# length is sum of both stacks

class MyQueue:

    def __init__(self):
        self.push_stack = []
        self.pop_stack = []

    def push(self, x: int) -> None:
        self.push_stack.append(x)

    def pop(self) -> int:
        if len(self.pop_stack) == 0:
            # O(n)
            while len(self.push_stack) > 0:
                self.pop_stack.append(self.push_stack.pop())
        return self.pop_stack.pop() #O(1)
        

    def peek(self) -> int:
        return self.pop_stack[-1] if self.pop_stack else self.push_stack[0]

    def empty(self) -> bool:
        return len(self.push_stack) + len(self.pop_stack) == 0



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()