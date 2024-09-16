# // Time Complexity : push:O(1) pop:Amortized time O(1) Worse Case O(N) peek & isEmpty: O(1)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Did not clearly get what they were asking

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.s1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        # Two stacks approach where during the first pop, you pop all the elemets creating a stack in the second list with the smalles value on top
        # When you are done poping values from s2, then you repeat the above step.
        if len(self.s2) > 0:
            return self.s2.pop()
        
        while len(self.s1) > 0:
            self.s2.append(self.s1.pop())
        return self.s2.pop()
        
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.s2) > 0:
            return self.s2[-1]
        else:
            return self.s1[0]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.s1) == 0 and len(self.s2) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()