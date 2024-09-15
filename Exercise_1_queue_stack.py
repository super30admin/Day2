# Time Complexity : pop and peek is O(1) and push is O(N)
#  Space Complexity : O(N)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No 
class MyQueue(object):

    def __init__(self):
        self.delete_stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        insert_stack = []
        while len(self.delete_stack) > 0:
            insert_stack.append(self.delete_stack.pop())
        insert_stack.append(x)
        
        while len(insert_stack) > 0:
            self.delete_stack.append(insert_stack.pop())
                  
    def pop(self):
        """
        :rtype: int
        """
        if self.delete_stack.empty():
            print("Queue Empty")
        else:
            return self.delete_stack.pop()
        
        
    def peek(self):
        """
        :rtype: int
        """
        return self.delete_stack[len(self.delete_stack)-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.delete_stack) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()