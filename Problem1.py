"""
// Time Complexity : push() - O(n), where size of queue, pop(),peek() and empty() - O(1)
// Space Complexity : O(n), auxilary stack is used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""

class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.my_q=[]

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        aux=[] #auxilary stack

        if self.empty(): #if queue is empty, push the element
            self.my_q.append(x)
            
        else: #else transfer the all the elements into an auxillary stack and add the new element to original stack and transfer 
              #back all the elements from auxilary stack, this way the new element will be at the bottom of the stack my_q
            while self.my_q:
                aux.append(self.my_q.pop(0))
            self.my_q.append(x)
            while aux:
                self.my_q.append(aux.pop(0))
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if not self.empty(): #pop the topmost element and return
            return self.my_q.pop()
            
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        return self.my_q[-1] #return the topmost element

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if not self.my_q:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()