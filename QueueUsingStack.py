#TimeComplexity:Push=O(1), Pop and Peek = Amortized O(1)
#SpaceComplexity: 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
#Implement Stack using Array.
class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.PushStack=[]
        self.PopAndPeekStack=[]

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.PushStack.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        #if not self.PopAndPeekStack and self.PushStack:
            
        if not self.PopAndPeekStack:
            while(self.PushStack):
                self.PopAndPeekStack.append(self.PushStack.pop())
            return self.PopAndPeekStack.pop()
        else:
            return self.PopAndPeekStack.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if not self.PopAndPeekStack:
            while(self.PushStack):
                self.PopAndPeekStack.append(self.PushStack.pop())
            return self.PopAndPeekStack[-1]
        else:
            return self.PopAndPeekStack[-1]       

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return (not self.PushStack and not self.PopAndPeekStack)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
