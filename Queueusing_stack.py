#// Did this code successfully run on Leetcode :Yes
#// Any problem you faced while coding this :None


#// Your code here along with comments explaining your approach
we have used two stacks to implement this.In one we perfom push operation and the other one is for pop and peek operations.for push method we just push the element to stack1.for pop method we check whether if stack2 is emptyif yes then we pop the elements from stack1 and insert them to stack2 till tack1 is empty.then we get the peek from stack2.




class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1=[]
        self.stack2=[]
    def transfer(self):
        while (len(self.stack1)!=0):
            self.stack2.append(self.stack1.pop())

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        #O(1) time and space complexity
        self.stack1.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        #O(1) time and space complexity best case
        #O(n) time and space complexity worst case.
        if len(self.stack2)==0:
            self.transfer()
        return self.stack2.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        #O(1) time and space complexity best case
        #O(n) time and space complexity worst case.
        if len(self.stack2)==0:
            self.transfer()
        return self.stack2[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return len(self.stack1)==0 and len(self.stack2)==0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()