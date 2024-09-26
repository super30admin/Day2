# Time Complexity : O(n) = n , Amortized O(1) as mentioned on Leetcode
# Space Complexity : O(n) = n
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I had to do somr minor debugging but I got it working


# Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.main_stack = []
        self.back_stack = []
        self.top = -1
        self.length = 0
        self.peeker = None

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if len(self.main_stack) == self.top+1:
            self.top+=1
            self.main_stack.append(x)
        else:
            self.top+=1
            self.main_stack[self.top] = x
        self.length += 1
        
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if self.top>=0:
            current = self.top
            self.back_stack = [-1 for x in range(self.length)]
            index = 0
            while current >= 0:
                self.back_stack[index] = self.main_stack[current]
                index+=1
                current -= 1
            res = self.back_stack[self.top]
            self.top -= 1
            current = self.top
            index = 0
            while current >= 0:
                self.main_stack[index] = self.back_stack[current]
                index+=1
                current -= 1
            self.back_stack = []
            return res
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.main_stack[0]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return self.top == -1

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(10)
print(obj.pop())
print(obj.empty())
