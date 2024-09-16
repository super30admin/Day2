# Time Complexity : 
	# push: O(1)
	# pop: O(1) [Amortized]
	# peek: O(1) [Amortized]
	# empty: O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
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
        self.peek()
        return self.outStack.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.outStack) == 0:
            while len(self.inStack) != 0:
                self.outStack.append(self.inStack.pop())
        if len(self.outStack) != 0:
            return self.outStack[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        
        return (len(self.inStack) == 0 and len(self.outStack) == 0)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()