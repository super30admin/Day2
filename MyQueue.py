# // Time Complexity : O(1) - if we run out of elements in pop_stack then worse case is O(n) for pop and peek
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No
class MyQueue(object):

    def __init__(self):
        self.push_stack = []
        self.pop_stack = []

    def fill_stack(self):
        # if pop stack is empty, then push all elements from push stack to pop stack
        if len(self.pop_stack) == 0:
            while self.push_stack:
                element = self.push_stack.pop()
                self.pop_stack.append(element)

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.push_stack.append(x)

    def pop(self):
        """
        :rtype: int
        """
        # if pop stack is empty, fill the pop stack
        # - O(n) if the stack needs to be filled
        self.fill_stack()
        return self.pop_stack.pop()

    def peek(self):
        """
        :rtype: int
        """
        # if pop stack is empty, fill the pop stack
        # - O(n) if the stack needs to be filled
        self.fill_stack()
        return self.pop_stack[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.push_stack) == 0 and len(self.pop_stack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
