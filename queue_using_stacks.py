"""
****Implement queue from two stacks****
TIME COMPLEXITY:
1. push operation: O(1)
2. pop operation: O(2n) = O(n)
3. peek operation: O(2n) = O(n)
4. isempty: O(1)

SPACE COMPLEXITY:
1. push operation: O(N)
2. pop operation: O(2N) = O(N)
3. peek operation: O(2N) = O(N)
4. isempty: O(1)

Yes it passed all the test cases in leetcode

Any problems faced: LifoQueue is a new datastructure.

"""

# LifoQueue is the stack of python
from queue import LifoQueue  # python stack


class MyQueue:

    def __init__(self):
        self.s1 = LifoQueue()  # main stack

    def push(self, x: int) -> None:
        self.s1.put(x)

    def pop(self) -> int:
        if self.s1.empty():
            return None
        # transfer elements from stack s1 to stack s2
        s2 = LifoQueue()
        while self.s1.empty() == False:
            s2.put(self.s1.get())
        # pop the element which will be first element of queue
        to_be_returned = s2.get()
        # Then recreate stack s1 from stack s2
        while s2.empty() == False:
            self.s1.put(s2.get())
        # return the popped element
        return to_be_returned

    def peek(self) -> int:
        if self.s1.empty():
            return None
        # transfer elements from stack s1 to stack s2
        s2 = LifoQueue()
        while self.s1.empty() == False:
            s2.put(self.s1.get())
        # pop the element which will be first element of queue
        to_be_returned = s2.get()
        # Then recreate stack s1 from stack s2
        self.s1.put(to_be_returned)
        while s2.empty() == False:
            self.s1.put(s2.get())
        # return the popped element
        return to_be_returned

    def empty(self) -> bool:
        return self.s1.empty()

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()