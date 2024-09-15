# Time Complexity : O(1) for push, O(n) for pop, O(n) for peek, O(1) for empty => amortized O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:

class MyQueue:

    # MyQueue constructor : initialize two stacks - stack1 and stack2
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    # Append x to stack1
    def push(self, x: int) -> None:
        self.stack1.append(x)

    # If stack2 is empty, pop each element from stack1 and push to stack2 and then pop the top element of stack2
    # Else pop the top element of stack2
    def pop(self) -> int:
        self.peek()
        return self.stack2.pop()

    # If stack2 is empty, pop each element from stack1 and push to stack2 and then return the top element of stack2
    # Else return the top element of stack2
    def peek(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    # If both stack1 and stack2 are empty, then the queue is empty
    def empty(self) -> bool:
        return not self.stack1 and not self.stack2

queue = MyQueue()
queue.push(1)
queue.push(2)
print(queue.peek())
print(queue.pop())
print(queue.empty())