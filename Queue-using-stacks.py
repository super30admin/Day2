""" 
Time Complexity : Amortized O(1) and worst case is O(n) where n is no of elements
Space Complexity :  O(n) where n is no elements
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach - I have two list for back and front. I am just appending in back and while
popping I am taking from front. If it is empty then I am transfering all the elements from back to front
"""

class MyQueue:

    def __init__(self):
        self.front = []
        self.back = []
        

    def push(self, x: int) -> None:
        self.back.append(x)
        

    def pop(self) -> int:
        if len(self.front) == 0 and len(self.back) == 0:
            return -1
        
        if len(self.front) == 0:
            while len(self.back) != 0:
                self.front.append(self.back.pop())
        return self.front.pop()
        

    def peek(self) -> int:
        if len(self.front) == 0 and len(self.back) == 0:
            return -1
        
        if len(self.front) == 0:
            while len(self.back) != 0:
                self.front.append(self.back.pop())
        return self.front[-1]
        

    def empty(self) -> bool:
        if len(self.back) == 0 and len(self.front) == 0:
            return True
        return False