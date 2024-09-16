# // Time Complexity : Amortized O(1)   Worst case :O(n) 
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self):
        self.queue = []
        self.dup_queue = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.queue.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        # No elements in the stack to pop
        while not self.queue and not self.dup_queue:
            return -1
        
       #Elements in original queue but not duplicate queue:
        if not self.dup_queue:
            while self.queue:
                self.dup_queue.append(self.queue.pop())
          
        return self.dup_queue.pop()
            
            
        

    def peek(self) -> int:
        
        #No elements to peek
        while not self.queue and not self.dup_queue:
            return -1
        
       #Elements in original queue but not duplicate queue:
        if not self.dup_queue:
            while self.queue:
                self.dup_queue.append(self.queue.pop())
            
        return self.dup_queue[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.queue and not self.dup_queue


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

