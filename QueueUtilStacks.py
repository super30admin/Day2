# Time Complexity : push: O(1), pop & peek: O(n), empty: O(1)
# Space Complexity : O(n), where n is the number of elements in both stacks
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class MyQueue(object):

    def __init__(self):
        # always appending to this stack
        self.inStack = []
        # always popping from this stack
        self.outStack = []

    def push(self, x):
        self.inStack.append(x)

    def pop(self):
        # calling peek because it does not mutate the containers
        # and has the same underlying logic to pop before returning
        self.peek()
        return self.outStack.pop()

    def peek(self):
        # shifting all elements from inStack to outStack and returning the top of outStack.
        if len(self.outStack) == 0:
            while len(self.inStack) != 0:
                self.outStack.append(self.inStack.pop())
        return self.outStack[len(self.outStack)-1]


    def empty(self):
        # if both stacks are empty.
        return len(self.inStack) == 0 and len(self.outStack) == 0

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
print obj.pop()
print obj.peek()
print obj.empty()
