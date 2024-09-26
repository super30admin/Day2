'''
Time Complexity :
For push: O(1)
For pop: O(n)

Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this :None

Solution: Create 2 stacks which would contain the elements.
For Push: Push the element into the First stack
For Pop: If the second stack is empty, transfer the elements from
the First stack to the second stack and pop the element from the
second stack.
'''


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []

    def transfer(self, x: list, y: list):
        while len(x) != 0:
            y.append(x.pop())

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """

        if len(self.stack2) == 0:
            self.transfer(self.stack1, self.stack2)

        return self.stack2.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.stack2) == 0:
            self.transfer(self.stack1, self.stack2)
        return self.stack2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.stack1) == 0 and len(self.stack2) == 0

#Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(10)
obj.push(20)
obj.push(30)
print("Fist Element is " + str(obj.pop()))
print("Last element is " + str(obj.peek()))