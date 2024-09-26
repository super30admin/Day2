'''
    Time Complexity:
        Everything runs in constant time on average.
        pop() and peek() will run in linear time occassionally.
        For eg, if we push 1M values in the stack and then pop:
            The first pop will take O(1M) to move the data from main stack to secondary stack.
            The next 999K pops will run in O(1) time.

    Space Complexity:
        O(n)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Two Stack
'''
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self._main_stack = []
        self._scnd_stack = []


    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self._main_stack.append(x)


    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self._scnd_stack.pop()


    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self._scnd_stack) == 0:
            while self._main_stack:
                self._scnd_stack.append(self._main_stack.pop())

        return self._scnd_stack[-1]


    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self._main_stack) == 0 and len(self._scnd_stack) == 0



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
