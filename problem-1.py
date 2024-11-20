#Time Complexity: O(1) for push, O(n) for push and peek
#Space Complexity: O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No


class MyQueue:
#Initialize stacks
    def __init__(self):
        self.stack1 = []
        self.stack2 = []        

    def push(self, x: int) -> None:
        self.stack1.append(x)
        
#Reverse the stack1 by poping and pushing into stack2 and pop top of stack2 to satisfy FIFO
    def pop(self) -> int:
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        pop_val = self.stack2.pop()
        
        while self.stack2:
            self.stack1.append(self.stack2.pop())
        return pop_val
#Reverse the stack1 by poping and pushing into stack2 and return top of stack2 to satisfy FIFO        

    def peek(self) -> int:
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        top = self.stack2[-1]
        while self.stack2:
            self.stack1.append(self.stack2.pop())
        return top
        
#Return if stack is empty
    def empty(self) -> bool:
        return not self.stack1
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()