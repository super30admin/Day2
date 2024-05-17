"""
Design-2

Problem 1:(https://leetcode.com/problems/implement-queue-using-stacks/)

Time Complexity : For all operations it's O(1) but for peek and pop it is amortized O(1) which is an average of O(1) and in worst case O(n)
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
We're using 2 stacks, one is in_stack where we push all the elements, and another is out_stack which we use when we receive a pop or peek operation to get the front element.
In order to get front element if the out_stack is empty we'll push all the in_stack elements to out_stack. Whenever we get pop operation we pop the element from the out_stack
to preserve the order. When the out_stack gets empty and we recieve a pop operation we transfer all the elements in the in_stack to out_stack. Peek is also similar since we have to return top of the out_stack element without popping it
other operations such as empty just takes checking the length of both stacks.
"""



class MyQueue:

    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        self.in_stack.append(x)

    def pop(self) -> int:
        if len(self.out_stack) == 0:
            while(len(self.in_stack) != 0):
                self.out_stack.append(self.in_stack.pop())
        popped_value = self.out_stack.pop()
        return popped_value
            
    def peek(self) -> int:
        if len(self.out_stack) == 0:
            while(len(self.in_stack) != 0):
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]
        

    def empty(self) -> bool:
        return len(self.in_stack) == 0 and len(self.out_stack) == 0
            
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()