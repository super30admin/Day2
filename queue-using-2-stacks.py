class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = [] #push_stack
        self.stack2 = [] #pop_and_top_stack

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        # Complexity: O(1)
        # Push all elements in stack1
        self.stack1.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        # Complexity: Amortized O(1)
        # Operations here same as peek but pop the top element
        self.peek()
        return self.stack2.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        # Complexity: Amortized O(1)
        # Handle case for when both stacks are empty
        if self.stack1 == [] and self.stack2 == []:
            return null
        # If stack 2 is empty, push elements from stack1 to stack2
        # Return top element of stack2
        if self.stack2 == []:
            while self.stack1 != []:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        # Complexity: O(1)
        # We need to check whether both of the stacks are empty
        return self.stack1 == [] and self.stack2 == []


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()