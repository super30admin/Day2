# // Time Complexity : O(1) for each function call made to MyHashMap class functions
# // Space Complexity : O(n) where n is the number of elements stored in the hashmap  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none


# // Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # maintaining two stack for ease of operations
        self.in_stack = []
        self.out_stack = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.in_stack.append(x)
            

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.out_stack.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.out_stack:
            while self.in_stack:
                top = self.in_stack.pop()
                self.out_stack.append(top)
        return self.out_stack[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if not self.in_stack and not self.out_stack:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()