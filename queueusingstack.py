'''
Approch is to maintain a two stack which behaves like queue 
      queue =  in_stack + out_stack
      

'''

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.in_stack = []          #stack to maintain the input 
        self.out_stack = []         #stack to maintain the output
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        Time complexity O(1)
        """
        self.in_stack.append(x)       # pushing the x to in_stack
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        Time complexity O(n) in worst case when we perform pop first time after appending n elements
        """
        # if there is element in out_stack return top of the out_stack
        # else pop all the element from instack and push them in the outstack and return the top element
        # and return top of the out_stack
        
        if self.out_stack: return self.out_stack.pop()
        while self.in_stack:
            self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()

    def peek(self) -> int:
        """
        Get the front element.
        Time complexity O(n) in worst case when we perform peek first time after appending n elements

        """
        # same as the pop // return the element at top
        if self.out_stack: return self.out_stack[-1]
        while self.in_stack:
            self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        Time complexity O(1) 
        """
        
        # if both the stacks are empty return True else returhn True
        return not self.in_stack and not self.out_stack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()