# Time Complexity : Amortized O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Stack:
    def __init__(self):
        self.arr = []
        self.arrsize  = 0
    
    def push(self,val: int) -> None:
        self.arr.append(val)
        self.arrsize += 1
        
    def pop(self):
        if self.isEmpty():
            return None
        self.arrsize -= 1
        return self.arr.pop()
    def size(self):
        return self.arrsize
    def isEmpty(self):
        if self.arrsize == 0:
            return True
        return False
    def top(self):
        if self.isEmpty():
            return None
        return self.arr[self.arrsize - 1]

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.pushStack = Stack()
        self.popStack = Stack()
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.pushStack.push(x)
        
        

    def pop(self) -> int:
        self.peek()
        return self.popStack.pop()
        

    def peek(self) -> int:
        if self.popStack.isEmpty():
            while self.pushStack.isEmpty() == False:
                self.popStack.push(self.pushStack.pop())
        return self.popStack.top()
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.popStack.isEmpty() and self.pushStack.isEmpty():
            return True;
        return False;



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()