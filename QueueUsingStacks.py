"""

Implement a first in first out (FIFO) queue using only two stacks. 
The implemented queue should support all the functions of a 
normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) - Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, 
peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. 
You may simulate a stack using a list or deque (double-ended queue) as long 
as you use only a stack's standard operations.

"""

  #Time Complexity : O(n) for push, O(1) for pop 
  #Space Complexity : O(n)
  #Did this code successfully run on VSCode : Yes
  #Any problem you faced while coding this : None

class MyQueue:

    # Initializing 2 stacks
    # One stack to store elements as they come
    # 2nd stack to push elements in reverse order to fulfill FIFO for queue
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    # To enqueue, can just push elements normally like in a stack
    def push(self, x: int) -> None:     
        self.stack1.append(x)

    # To pop, first if both the stacks are empty, return null
    # 
    def pop(self) -> int:
        if len(self.stack1) == 0 and len(self.stack2) == 0:
            return self.empty()
        elif len(self.stack1) > 0 and len(self.stack2) == 0:
            while len(self.stack1):
                #self.stack1.pop(self.stack2)
                temp = self.stack1.pop()
                self.stack2.append(temp)
            return self.stack2.pop()

        else:
            return self.stack2.pop()

    def peek(self) -> int:
        if len(self.stack1) == 0 and len(self.stack2) == 0:
            return self.empty()
        elif len(self.stack1) > 0 and len(self.stack2) == 0:
            while len(self.stack1):
                #self.stack1.pop(self.stack2)
                temp = self.stack1.pop()
                self.stack2.append(temp)
            return self.stack2[len(self.stack2) - 1]

        else:
            return self.stack2[len(self.stack2) - 1]
        

    def empty(self) -> bool:
        return (self.stack1 or self.stack2) == []

    def show(self):
      return self.stack2
        

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

s = MyQueue()
s.push('1')
s.push('2')
s.push('3')
s.push('4')
s.push('5')
s.push('6')
print(s.pop())
print(s.show())
print(s.peek())
print(s.empty())
print(s.show())
