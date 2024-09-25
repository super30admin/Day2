# Time Complexity : Over a sequenece of inserts, the amortized cost for insert is O(1). 
# Space Complexity : We don't use any other storage apart from the two stacks required.
# Did this code successfully run on Leetcode : Yes, it ran successfully on LeetCode.
# Any problem you faced while coding this : No.


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here. Space complexity is O(2n) => O(n) because we need to maintain two stacks of size n for simulating a queue of length n.
        """
        self.stackins = []
        self.stackdel = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue. (Time complexity is O(n), O(1) for each pop and O(1) for each append. Therefore taking O(n) for n elements.)
        """
        while len(self.stackdel) > 0:
            self.stackins.append(self.stackdel.pop())
        self.stackins.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element. (Time complexity is O(n), O(1) for each pop and O(1) for each append. Therefore taking O(n) for n elements.)
        """
        while len(self.stackins) > 0:
            self.stackdel.append(self.stackins.pop())
        return self.stackdel.pop()

    def peek(self) -> int:
        """
        Get the front element. (Time complexity is O(n), O(1) for each pop and O(1) for each append. Therefore taking O(n) for n elements.)
        """
        while len(self.stackins) > 0:
            self.stackdel.append(self.stackins.pop())
        return self.stackdel[-1]        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.stackins) == 0 and len(self.stackdel) == 0:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()