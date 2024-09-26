# Time Complexity : O(N) as pop and peek are O(N)
# Space Complexity : O(N) for two stacks, it would be O(2*N), which is O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, it took me a while to understand how to implement this problem

class Stack:

    def __init__(self):
        self.mystack = []

    def push(self, val) -> None:
        self.mystack.append(val)

    def pop(self) -> int:
        if len(self.mystack) == 0:
            return None
        return self.mystack.pop()
    
    def peek(self) -> int:
        if len(self.mystack) == 0:
            return None
        return self.mystack[-1]
    
    def empty(self) -> bool:
        return len(self.mystack) == 0
    
class MyQueue:

    def __init__(self):
        self.inStack = Stack()
        self.outStack = Stack()

    def push(self, val):
        self.inStack.push(val)

    # using two stacks, pop is O(N) as the first element of the queue 
    # is the bottommost element in the inStack
    # so we pop out the elements from inStack and 
    # push them onto the outStack one by one
    # then pop out the top element from outStack, 
    # which was the bottommost element in the inStack
    def pop(self) -> int:
        while not self.inStack.empty():
            self.outStack.push(self.inStack.pop())
        res = self.outStack.pop()
        while not self.outStack.empty():
            self.inStack.push(self.outStack.pop())
        return res

    # O(N) as same logic as pop, except we just return the first element of the queue, not pop
    def peek(self) -> int:
        while not self.inStack.empty():
            self.outStack.push(self.inStack.pop())
        res = self.outStack.peek()
        while not self.outStack.empty():
            self.inStack.push(self.outStack.pop())
        return res
        
    # True if both inStack and outStack are empty
    def empty(self) -> bool:
        return self.inStack.empty() and self.outStack.empty()

obj = MyQueue()
x = 5
obj.push(x)

print("\nPopped Element: "+str(obj.pop()))
print("\nFront of queue: "+str(obj.peek()))
print("\nIs the queue empty: "+str(obj.empty()))
print()