# // Time Complexity : O(1) for push(), Amortized O(1) for pop() and peek()
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.pushstack=[]
        self.popandpeekstack=[]


    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.pushstack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.popandpeekstack:
            while self.pushstack:
                self.popandpeekstack.append(self.pushstack.pop())
        
        return self.popandpeekstack.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.popandpeekstack:
            while self.pushstack:
                self.popandpeekstack.append(self.pushstack.pop())
        
        return self.popandpeekstack[-1]


    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if not self.pushstack and not self.popandpeekstack:
            return True
        else:
            return False

# Test Code
queue = MyQueue();
queue.push(1);
queue.push(2);  
print(queue.peek());  #returns 1
print(queue.pop());   #returns 1
print(queue.empty()); #returns false