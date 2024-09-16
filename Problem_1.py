"""

Time Complexity : O(1) - Push, O(n) - Pop, O(n) - Peek, O(1) - Empty.
Space Complexity : O(n)
    
"""

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.push_ = []
        self.pop_ = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.push_.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.pop_.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.pop_:
            while self.push_:
                self.pop_.append(self.push_.pop())
        return self.pop_[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.push_ and not self.pop_
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()