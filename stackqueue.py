// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced an issue where I initialized the list as empty and checked that if it is null under if condiiton


// Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
      # initializing two empty stacks
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
      #pushing all the elements in the stack1
        self.stack1.append(x)

    def pop(self) -> int:
        if not self.stack2: #checking if the stack2 is empty
            while self.stack1: # using while to add the elements from the stack1 to the stack2 until the last element
                self.stack2.append(self.stack1.pop()) 
        return self.stack2.pop() # returning the top element in the stack2

    def peek(self) -> int:
        if not self.stack2: #same logic as the above
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1] # returning the last element in the stack2

    def empty(self) -> bool:
        return not self.stack1 and not self.stack2 # checks and returns a boolean value if the stack1 and stack2 is empty or not
