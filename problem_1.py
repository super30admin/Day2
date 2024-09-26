'''https://leetcode.com/problems/implement-queue-using-stacks/'''

from collections import deque

# Time Complexity : Push O(1), pop(N) amortized
# Space Complexity : O(N) for N elements inserted to Stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyQueue:

    def __init__(self):
        self.push_stk = deque() # new elements will go in this stack
        self.que_stk = deque() # elements are always in queue order in this stack
        

    def push(self, x: int) -> None: # O(1)
        self.push_stk.append(x)
        
    
    def transfer_elements(self) -> None:
        """
        transfers all elements from push_stk to que_stk.
        Only transfer if que_stk is empty
        """
        if len(self.que_stk) == 0:
            while len(self.push_stk) != 0:
                self.que_stk.append(self.push_stk.pop())
                

    def pop(self) -> int: # On an average O(1) (amortized)
        """
        Worst case O(N). On an average O(1) (amortized)
        """
        self.transfer_elements() #  Only transfers when que_stk is empty
        return self.que_stk.pop() # self.que_stk is in 'Queue' order
        

    def peek(self) -> int:  # On an average O(1) (amortized)
        """
        Worst case O(N). On an average O(1) (amortized)
        """
        self.transfer_elements() 
        return self.que_stk[-1]
        

    def empty(self) -> bool: # O(1)
        return len(self.que_stk) == 0 and len(self.push_stk) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()