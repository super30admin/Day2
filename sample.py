#Time-Complexity: O(1)
#Space-Complexity: O(n)

from inspect import stack

class MyQueue(object):
    def __init__(self):
        self.in_stk = []
        self.out_stk = []

	# Push element x to the back of queue...
    def push(self, x):
        self.in_stk.append(x)
        print("Element Pushed :", x)
        return ""

	# Remove the element from the front of the queue and returns it...
    def pop(self):
        if not self.in_stk and not self.out_stk:
            return "No Element in Queue!"

         
        self.peek()
        print("The Popped Element is:")
        return self.out_stk.pop()

	# Get the front element...
    def peek(self):
        if not self.out_stk:
            while self.in_stk:
                self.out_stk.append(self.in_stk.pop())

        if not self.out_stk and not self.in_stk:
            return "No Element in Queue!"
        else:
            return self.out_stk[-1]

	# Return whether the queue is empty...
    def empty(self):
        return not self.in_stk and not self.out_stk

Q = MyQueue()
print(Q.empty())
print(Q.peek())
print(Q.push(1))
print(Q.empty())
print(Q.push(2))
print(Q.push(3))
print(Q.peek())
print(Q.pop())
print(Q.peek())
print(Q.pop())
print(Q.pop())
print(Q.empty())
print(Q.pop())