"""
VERSION 2

****Implement queue from two stacks****
TIME COMPLEXITY:
1. push operation: O(1)
2. pop operation: O(n)
3. peek operation: O(n)
4. isempty: O(1)

SPACE COMPLEXITY:
1. push operation: O(N)
2. pop operation: O(2N) = O(N)
3. peek operation: O(2N) = O(N)
4. isempty: O(1)

Yes it passed all the test cases in leetcode

Any problems faced: LifoQueue is a new datastructure. 

"""

'''
In the first approach, in pop operation, all the contents from stack1 were popped to stack 2, then an element was popped from stack2. 
After that, all the elements were popped from stack s2 to stack s1.

In the second approach, in pop operation, if the stack s2 is empty, all the contents from stack1 were popped to stack 2, then an element was popped from stack2.
Most importantly, the elements were not popped from stack s2 to stack s1 again.

If the stack s2 was not empty, an element was popped from stack s2.

In the version 2, pop operation is optimized. 

* peek and pop operation work similarly.
* There is no change in push operation.
* isempty() is changed based on intuition and it is self explanatory.
'''

# LifoQueue is the stack of python
from queue import LifoQueue # python stack

class MyQueue:

    def __init__(self):        
        self.s1 = LifoQueue() # main stack
        self.s2 = LifoQueue()
        

    def push(self, x: int) -> None:
        self.s1.put(x)
        

    def pop(self) -> int:
        if self.s1.empty() and self.s2.empty():
            return None
        elif self.s2.empty():
            while self.s1.empty() == False:
                self.s2.put(self.s1.get())
            return self.s2.get()
        else:
            return self.s2.get()
        
        
    def peek(self) -> int:
        if self.s1.empty() and self.s2.empty():
            return None
        elif self.s2.empty():
            while self.s1.empty() == False:
                self.s2.put(self.s1.get())
            res = self.s2.get()
            self.s2.put(res)
            return res
        else:
            res = self.s2.get()
            self.s2.put(res)
            return res
        

    def empty(self) -> bool:
        return self.s1.empty() and self.s2.empty()


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
