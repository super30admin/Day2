"""
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:
void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.

Approach --
1. When pushing add all items to instack
2. While popping move all elements to outstack and pop
3. if next item is push, push to instack
4. then again for pop, push everything to outstack and pop

Time complexity - O(1)
Space complexity - O(1)
"""
class MyQueue:
    def __init__(self):
        self.instack = []
        self.outstack = []

    def push(self, x):
        self.instack.append(x)

    def pop(self):
        self.peek()
        return self.outstack.pop()


    def peek(self):
        if len(self.outstack) == 0:
            while len(self.instack) != 0:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]

    def empty(self):
        if len(self.instack) == 0 and len(self.outstack) == 0:
            return True
        else:
            return False


obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
obj.push(4)
obj.push(5)
print(obj.pop())
obj.push(6)
obj.push(7)
print(obj.peek())
obj.push(8)
print(obj.pop())
print(obj.empty())