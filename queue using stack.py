# Time complexity : O(1)
# Space Complexity : O(1)
class MyQueue:

    # Intitializing the empty in and out stacks
    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    # pushing the elements onto the in stack
    def push(self, x: int) -> None:
        self.in_stack.append(x)
    
    # In order to pop the element, first we peek if the element is there or empty, if present, then we remove the element from the out stack
    def pop(self) -> int:
        self.peek()
        return self.out_stack.pop()

     # In order to peek, we first check the out stack, if empty, then we move elements from "in" stack to the "out" stack so that we don't get 
     # empty stack issue
    def peek(self) -> int:
        if len(self.out_stack) == 0:
            while len(self.in_stack)!= 0:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

     # This function checks if both the stacks are empty or not
    def empty(self) -> bool:
        if len(self.in_stack) == 0 and len(self.out_stack) == 0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
