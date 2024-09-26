# Time Complexity : O(N) for push O(1) for pop,peek, empty
# Space Complexity : O(N) for stackSize
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes. I had a bug within my push function. I needed an else after 
# the if because I noticed I was appending the first value twice to the stack while I was debugging.
# another problem I had was solving the wrong problem...I stuck because I thought I was popping from the back 
# instead of the front of the queue


# Your code here along with comments explaining your approach
""" NOTES..
 - Queue is FIFO
 - Stack is LIFO
    - return []
    - temp = []
      if i put 1, return = [1]. new val is gonna be on bottom of return stack.
"""

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.tempStack = []
        self.returnStack = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        #check if both stacks are empty, then just append to the returnStack
        if not self.tempStack and not self.returnStack:
            self.returnStack.append(x)
        else:
            #going to have to move everything from returnStack to tempStack
            while self.returnStack:
                moveToTemp = self.returnStack.pop()
                self.tempStack.append(moveToTemp)
            #add the new value to returnStack (at this part returnStack is empty) this would make it the 
            #last value in the "queue"
            self.returnStack.append(x)

            #move everything back to the return stack
            while self.tempStack:
                moveToReturn = self.tempStack.pop()
                self.returnStack.append(moveToReturn)
            
        print(self.returnStack)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        #if there are items in my returnStack then just pop() and this will pop elements from the front of the "queue"
        if self.returnStack:
            val = self.returnStack.pop()
            return val
        else:
            return
    
    def peek(self) -> int:
        """
        Get the front element.
        """
        #just return last thing in the returnStack
        return self.returnStack[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.returnStack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()