# Time Complexity :

# O(1) for push() and empty()

# O(n) [Worst case] for pop() and peek()
# O(1) [Amortized/Avg case] for pop() and peek()


# Space Complexity :  

# O(n) since we need to create another stack for keeping 
# the lements in reverese order of their push



# Approach:
# Create two stacks , one for pushing elements into "inStack"inStack
# Another, for pushing elements from "inStack" to this new "outStack" only when we perform pop()

# In current approach, we use peek() call in pop(), to ensure safety chach that
# "outStack" is not emty, and we can retrieve the top element

class MyQueue(object):

    def __init__(self):
        self.instack = []
        self.outstack = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.instack.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        self.peek()
        return self.outstack.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        if (not self.outstack):
            while(self.instack):
                self.outstack.append(self.instack.pop())
        
        return self.outstack[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.instack and not self.outstack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()