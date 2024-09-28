# 232. Implement Queue using Stacks

# Implement the following operations of a queue using stacks.
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.pushstk = []
        self.popnpeek = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.pushstk.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.popnpeek)==0:
            while self.pushstk:
                x= self.pushstk.pop()
                self.popnpeek.append(x)
                
        return self.popnpeek.pop()
        
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.popnpeek)==0:
            while self.pushstk:
                self.popnpeek.append(self.pushstk.pop())
        
        return self.popnpeek[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.pushstk)==0 and len(self.popnpeek)==0

#  Time Complexity : O(1)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
