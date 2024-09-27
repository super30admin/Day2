"""
Runtime Complexity:
O(1) - because we just initialise two empty lists. The push() just appeneds the element to the end of the array so it don't need to change the position of other elements, which takes O(1). 
Same applies for pop(), we just pop the element from the end of the list without affecting the position of other elements. peek() returns the top element of the pop_stack which again takes O(1).
empty() just checks if both stacks len == 0 and returns true else false.

Space Complexity: O(n), because each operation takes O(1) but we need n storage space to compute those operation for 'n' elements.

-Yes, the code worked on leetcode.
"""


class MyQueue:

    def __init__(self):
        self.push_stack = []
        self.pop_stack = []
        

    def push(self, x: int) -> None:
        while self.pop_stack:
            self.push_stack.append(self.pop_stack.pop())
        self.push_stack.append(x)
        

    def pop(self) -> int:
        while self.push_stack:
            self.pop_stack.append(self.push_stack.pop())
        return self.pop_stack.pop()
        
        

    def peek(self) -> int:
        while self.push_stack:
            self.pop_stack.append(self.push_stack.pop())
        
        x = self.pop_stack.pop()
        self.pop_stack.append(x)
        return x
        
        

    def empty(self) -> bool:
        return not self.push_stack and not self.pop_stack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
