# used 2 stacks to implement queue.
# before performing pop and peek check move all the items to outstack if that is empty.
# time complexity for push and isempty - O(1)
# time complexity for pop and peek - O(N)
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack = [] # initializing python list as instack
        self.outStack = [] # initializing python list as outstack

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """

        self.inStack.append(x) # push new items to instack
        # print(self.inStack, self.outStack)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.moveItems() # calling move method.
        return self.outStack.pop() # pop peek(top) item from outstack

    def peek(self) -> int:
        """
        Get the front element.
        """
        self.moveItems() # calling move method.
        return self.outStack[-1] # extracting top element i.e., last inserted item to the outstack.

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if not self.inStack and not self.outStack:
            return True # if both stacks are empty return true.

    def moveItems(self):
        if not self.outStack: # if outstack is empty then push all items from instack to outstack
            while self.inStack:
                self.outStack.append(self.inStack.pop()) # pop one item at a time from instack and push to outstack.