#// Time Complexity :O(n)
#// Space Complexity :O(n)
#// Did this code successfully run on Leetcode :yes
#// Any problem you faced while coding this :no

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
        self.stack2.append(x)  
        self.stack1=[]
        i=len(self.stack2)-1
        while(i>=0): # adding values in 1 stack in reverse with respected to the other stack
            self.stack1.append(self.stack2[i])
            i=i-1
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.stack2.pop(0)
        return self.stack1.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.stack1[len(self.stack1)-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return self.stack1==[]


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()