class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.input = []
        self.output = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.input.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        val=self.output.pop()
        return val
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if(self.output == []):
            while(self.input != []):
                val=self.input.pop()
                self.output.append(val)
        ans=self.output[-1]
        return ans
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.input == [] and self.output == []:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()