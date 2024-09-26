
# // Time Complexity : Average-> O(1), worst case-> O(n)
# // Space Complexity :  O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No.

class MyQueue:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack = [] #main stack
        self.outStack = [] #stack where I store elemts to pop the first element.
       
    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inStack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if(self.outStack == []):
            while(self.inStack!=[]):
                self.outStack.append(self.inStack.pop())
       
        return self.outStack.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if(self.outStack == []):
            while(self.inStack!=[]):
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return ((self.inStack == []) and (self.outStack ==[]))


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()