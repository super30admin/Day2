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
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if not self.outstack and not self.instack:
            return True
        else:
            return False

#TC: for peek and pop worst case is O(N) and for empty and push O(1)
#SC: Asymptotically the SC is O(N) otherwise it is O(2N) as it maintains 2 stacks

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()