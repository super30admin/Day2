# Time Complexity : O(n) Amortized O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Tried both making enqueue costly and making dequeu costly


# Your code here along with comments explaining your approach 

class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.pushStack = []       #Two stacks one for push and the other for pop and peek
        self.popAndPeek = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.pushStack.append(x)
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """

        if len(self.popAndPeek) == 0:                  #Remove all elements from pushStack and store it in popStack and popped the first value
            while len(self.pushStack) != 0:
                self.popAndPeek.append(self.pushStack.pop())

        return self.popAndPeek.pop() if self.popAndPeek else float('inf')
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
    
        if  len(self.popAndPeek) == 0:
            while len(self.pushStack) != 0:
                self.popAndPeek.append(self.pushStack.pop())
        
        return self.popAndPeek[-1] if self.popAndPeek else float('inf')
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return len(self.pushStack) == 0 and len(self.popAndPeek) == 0

mq = MyQueue()
mq.push(2)
mq.push(3)
mq.push(1)
print (mq.peek())
mq.pop()