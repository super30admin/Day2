#Manideepa
#Time Complexity : O(1)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#Approach: Since queue is first-in-first-out data structure, we create another stack and pop the elements from first stack and push it to second stack for every operation of pop. This will give us a list in queue order
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1=[]
        self.stack2=[]
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        try:
            out = self.stack2.pop()
        except:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            out=self.stack2.pop()
        return out

    def peek(self) -> int:
        """
        Get the front element.
        """
        try:
            return self.stack2[-1]
        except:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            return self.stack2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return (not self.stack1) and (not self.stack2)
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()