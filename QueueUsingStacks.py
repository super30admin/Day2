class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inStack.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        
        if not self.outStack: 
            while self.inStack:
                self.outStack.append(self.inStack.pop())
            
            return self.outStack.pop()
        
        return self.outStack.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        
        if self.outStack:
            return self.outStack[-1]
        
        return self.inStack[0]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if not self.inStack and not self.outStack:
            return True
        else:
            return False
        
# Time and space complexity - Time complexity in average case would be O(1) and space complexity would be 2n
# Approach - Designing 2 stacks - one for push and one for pop, if pop comes and the second stack is empty, pop 
# all elements from 1st stack and pop from the second stack once each element is popped from 1st and sent to second.
# Followed what was used in class.


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
