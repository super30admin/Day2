# Time Complexity : 
# Push: O(1)
# Pop: O(1) average case and O(n) worst case
# Peek: O(1) average case and O(n) worst case
# Empty: O(1)

# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
Create 2 stacks 
Push elements into the first stack 
When we recieve a pop operation we transfer all the elements from the first stack to the second stack and then pop and return element from second stack(Similar with Peek)
Check if both stacks are empty in case of empty operation
class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.stack1.append(x)
        
    def transfer(self, stack1, stack2):
        while len(stack1)!=0:
            stack2.append(stack1.pop())
               
        
    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if len(self.stack2)==0:
            self.transfer(self.stack1,self.stack2)
        return self.stack2.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if len(self.stack2)==0:
            self.transfer(self.stack1,self.stack2)
        return self.stack2[-1]
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return len(self.stack1) == 0 and len(self.stack2) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()