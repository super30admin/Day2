// Time Complexity : Given for each operation below
// Space Complexity : O(2n) as 2 stacks are being used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was uncertain intially and used a single stack. Revising the same after class.


// Your code here along with comments explaining your approach - For pop and peek operation, we utilized a secondary stack to empty the 
elements of the initial stack and reverse the order during the process. Therefore, the first element in initial stack, which turns out 
to be the last element in the secondary stack, is removed and fetched using pop function. As a result, we had to incorporate an 
additional step in push operation to empty the contents of secondary stack back into the initial stack before inputting a new value 
using append function. For empty operation, we used 'not' operator to check if both the stacks are empty.
 

class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1 = []
        self.s2 = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        # O(n) - linear time complexity in worst-case scenario, which is less frequent
        while len(self.s2) != 0:
            self.s1.append(self.s2.pop())
        
        # O(1) - Constant time Complexity for append operation (best case scenario, which may also be the average time complexity)
        return self.s1.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        # O(n) - Linear time Complexity 
        while len(self.s1) != 0: 
            self.s2.append(self.s1.pop())
        return self.s2.pop()
      
    
    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        # O(n) - Linear time Complexity 
        while len(self.s1) != 0: 
            self.s2.append(self.s1.pop())
        peek = self.s2.pop()
        self.s2.append(peek)
        return peek
  

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        # O(1) - constant time Complexity 
        return not self.s1 and not self.s2


