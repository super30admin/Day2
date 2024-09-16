"""
Queue using Stacks
"""
"""
Time Complexity:

Push: O(1)
Pop: Amortized O(1)
Top: Amortized O(1)
Empty: O(1)
"""
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # 2 stacks:s1 and s2
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        # append x to s1
        self.s1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        # check if the stack is empty or not
        if (self.empty()):
            return None
        
        # check if s2 stack is empty or not
        if (len(self.s2) is 0):
            # check if s1 stack is empty or not
            if (len(self.s1) is not 0):
                # if s1 is not empty and s2 is empty
                # move the elements from s1 to s2
                while len(self.s1) is not 0:
                    self.s2.append(self.s1.pop())
                # then pop the last element appended to s2 stack
                return self.s2.pop()
        else:
            # return the last element in s2 if s2 is not empty
            return self.s2.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        # check if the stack is empty or not
        if (self.empty()):
            return None
        
        # check if s2 stack is empty or not
        if (len(self.s2) is 0):
            # check if s1 stack is empty or not
            if (len(self.s1) is not 0):
                # if s1 is not empty and s2 is empty
                # move the elements from s1 to s2
                while len(self.s1) is not 0:
                    self.s2.append(self.s1.pop())
                # then return the last element appended to s2
                return self.s2[-1]
        else:
            # return the last element appended to s2 when s2 is not empty
            return self.s2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        # check if both s1 and s2 stacks are empty or not
        if len(self.s1) == 0 and len(self.s2) == 0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()