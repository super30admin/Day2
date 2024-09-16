# Time Complexity : Push -> O(N), Pop -> O(1) 
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = []
        self.s2 = []
        self.front = None

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if self.empty():
            self.front = x
        
        while not self.empty():
            self.s2.append(self.s1.pop())
        
        self.s2.append(x)
        
        while len(self.s2) != 0:
            self.s1.append(self.s2.pop())
        
        print(self.s1)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        res = self.s1.pop()
        if not self.empty():
            self.front = self.s1[-1]
        return res

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.front
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return True if len(self.s1) == 0 else False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()