# // Time Complexity: O(n) for all operations, O(1) for empty()
# // Space Complexity:O(n)
# // Did this code successfully run on Leetcode: Yes
# // Any problem you faced while coding this: No


# I use 2 stacks to emulate a queue. The stack "queue" is where elements are appended. 
# Whenever we need to pop or peek, we transfer all the elememnts to temporary stack and then
# pop the top elememt.

class MyQueue:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.queue = []
        self.temp = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if self.temp:
            while(self.temp):
                self.queue.append(self.temp.pop())
        self.queue.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        while(self.queue):
            self.temp.append(self.queue.pop())
        return self.temp.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        while(self.queue):
            self.temp.append(self.queue.pop())
        return self.temp[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.queue or self.temp:
            return False
        return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
