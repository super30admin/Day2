# Time Complexity : 
# - Best Case O(1)
# - Worst Case O(n) (alternate push and pop operation, so we will have to trasnfer elements after every push operation)
# - Average Case O(n) : list.index() is used
# Space Complexity : O(n), using two stacks
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
#  - I am returning the last element in peek operation but the pop operation needs the index, so to find the index I have to iterate the list.

# // Your code here along with comments explaining your approach
class MyQueue(object):


    def __init__(self):
        self.in_stack = []
        self.out_stack = []


    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        # push in in_stack
        self.in_stack.append(x)

    def pop(self):
        """
        :rtype: int
        """
        # peek()
        # pop(peek())
        # first called peek, that will return the top element and not the index
        # then getting the index of the peek element in out_stack
        # then popping the peek element from out stack

        # if the queue is not empty, only then we can perform the pop operation
        if not self.empty():
            popIndex = self.out_stack.index(self.peek())
            return self.out_stack.pop()

        return

    def peek(self):
        """
        :rtype: int
        """
        # if out_stack is empty
        # pop all elements from in_stack & push in out_stack
        # until in_stack is not empty
        if not self.out_stack:
            while(self.in_stack):
                self.out_stack.append(self.in_stack.pop())
            
            # now in stack should be empty
            # and all elements are transferred in out stack
            
        # return top element
        if self.out_stack:
            return self.out_stack[-1]
       
        return None

    def empty(self):
        """
        :rtype: bool
        """ 
        # if both stacks are empty then the queue is empty
        return not (self.in_stack or self.out_stack)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()