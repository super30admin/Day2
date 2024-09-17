# Runtime: 28 ms, faster than 79.78% of Python3 online submissions for Implement Queue using Stacks.
# Memory Usage: 14.4 MB, less than 11.81% of Python3 online submissions for Implement Queue using Stacks.

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.instack = []
        self.outstack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.instack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        
        return self.outstack.pop()
        
    def peek(self) -> int:
        """
        Get the front element.
        """
        if(len(self.outstack) <= 0):
            while (len(self.instack) > 0):
                self.outstack.append(self.instack.pop())
        
        return self.outstack[-1]
    
    def empty(self) -> bool:
        
        return len(self.outstack) == 0 and len(self.instack) == 0

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
# obj.push(2)

# param_2 = obj.pop()
# param_3 = obj.peek()
param_4 = obj.empty()
# print(param_2, param_3, param_4)