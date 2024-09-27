class MyQueue:

    def __init__(self):
        
        """
        Initialize your data structure here.
        Space Complexity: O(n)
        We use pythons list data structure for stack
        """
        self.stack_one = []
        self.stack_second = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        Time Complexity: O(n)
        """
        if not self.stack_one and not self.stack_second:
            self.stack_one.append(x)
        else :
            while(self.stack_one):
                self.stack_second.append(self.stack_one.pop())
            self.stack_second.append(x)
            while(self.stack_second):
                self.stack_one.append(self.stack_second.pop())
        print(self.stack_one)
        
            
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        Time Complexity: O(1)
        """
        return self.stack_one.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        Time Complexity: O(1)
        """
        return self.stack_one[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        Time Complexity: O(1)
        """
        return True if not self.stack_one else False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()