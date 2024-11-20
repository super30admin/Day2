# Time Complexity : O(1) amortized time. The O(2n) pop operation does not occur often and overall amortized time is O(1)
# Space Complexity : O(n) where n is the number of elements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

### IMPLEMENT QUEUE USING STACK ###

class MyQueue:

    def __init__(self):
        self.s1 = [] # Initialize two stacks
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x) # We just add new elements to s1

    def pop(self) -> int:
        self.peek() # We call peek to make sure that if s2 is empty it will push s1's elements to s2 in reverse order
        return self.s2.pop() # Pop the top element of s2 which is the first entered among all current elements

    def peek(self) -> int:
        if not self.s2: # If s2 is empty then pop all elements in s1 and put them in s2. This will give reverse order
            while self.s1: # of s1 and we can use this to pop in FIFO order
                self.s2.append(self.s1.pop()) #Pop all elements from s1 and push them to s2. This will store in s2 in s1's FIFO order 
        return self.s2[-1] # Return top of s2 which is peek of s1 which is first entered among all current elements

    def empty(self) -> bool:
        return not self.s1 and not self.s2 #Empty only if both stacks are empty


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()