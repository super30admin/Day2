'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
Email       : pavan1011@gmail.com
S30 SlackID : RN32MAY2021
=================================
'''
'''
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push 
to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. 
You may simulate a stack using a list or deque (double-ended queue) 
as long as you use only a stack's standard operations.

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.


Follow-up: Can you implement the queue such that each operation is amortized
 O(1) time complexity? In other words, performing n operations will take overall 
 O(n) time even if one of those operations may take longer.
'''
#-----------------
# Time Complexity: 
#-----------------
# O(N) for push()
# O(1) for pop(), peek() and empty()

#------------------
# Space Complexity: 
#------------------
# O(N): since we use two stacks for push and one stack for other operations

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             : 28 ms (77.13 %ile)
# Space            : 14.3 MB (90.15 %ile)


class MyQueue:
# We can use two stacks to implement the queue.

# One stack stores last item added at the top (last_in)
# Another stores the first item added to last_in stack (first_out)

# Two possible ways: Make push() operation expensive or pop()

# Since an expensive pop() also means an expensive peek(),
# I choose the first approach of making push expensive. How?

# - For every push(), reverse first_out and store it in last_in. 
# - Append to last_in
# - Reverse last_in and store in first_out for pop() and peek()
# - For pop() or peek(), pop from first_out

    def __init__(self):
        """
        Initialize your data structure here.
        """

        self.last_in = []
        self.first_out = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """

        # Reverse the current stack holding the right order of items to
        # be popped out
        while self.first_out:
            self.last_in.append(self.first_out.pop())

        # Append last item pushed to last_in
        self.last_in.append(x)

        
        # Reverse last_in and store the items in correct order for pop() or
        # peek() operations
        while self.last_in:
            self.first_out.append(self.last_in.pop())

        
        # print("Pushed: {0}".format(self.last_in[-1]))

        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        # popped_item = self.first_out[-1]
        # print("Popped: {0}".format(popped_item))
        return self.first_out.pop()

        

    def peek(self) -> int:
        """
        Get the front element.
        """
        # print(self.first_out[-1])
        return self.first_out[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.first_out
        


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
obj.push(4)
obj.pop()
obj.push(5)

param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()