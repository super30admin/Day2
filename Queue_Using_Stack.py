"""
Time Complexity:
Push: O(1)
Pop: O(n)
peek: O(1)
empty: O(1)

Space Complexity:
Push: O(n)
Pop: O(n)
Peek: O(n)
Empty: O(n)
"""

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.main_stack = []
        self.temp_stack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.main_stack.append(x)
        print("After push", self.main_stack)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.main_stack) == 0:
            return None
        self.temp_stack = []
        for val in self.main_stack[::-1]:
            self.temp_stack.append(val)
            
        self.main_stack = []
        ret = self.temp_stack.pop()
        print("temp_stack",self.temp_stack)
        
        for val in self.temp_stack[::-1]:
            self.main_stack.append(val)
            
        print("After pop", self.main_stack)
        return ret
    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.main_stack) == 0:
            return None
        
        for val in self.main_stack[::-1]:
            self.temp_stack.append(val)
        
        ret = self.temp_stack[-1]
        self.temp_stack = []
        print("After peek", self.main_stack)
        return ret

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        print("While checking empty",self.main_stack)
        if len(self.main_stack) == 0:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()