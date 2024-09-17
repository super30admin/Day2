# Time Complexity : push O(1) pop O(1) peek O(1) worst O(n) remove O(1)
# Space Complexity :O(N)
from collections import deque
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1=[]
        self.s2=[]


    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.s1.append(x)



    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """

        self.peek()
        return self.s2.pop()


    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.s2==[]:
            while self.s1!=[]:
                self.s2.append(self.s1.pop())
                print("p")
        return self.s2[-1]


    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return self.s1==[] and self.s2==[]



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
