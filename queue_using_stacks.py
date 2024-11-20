#Time Complexity :   O (n)  average case: O(1) 
#Space Complexity :  O(n) 
#Did this code successfully run on Leetcode :    Yes
#Any problem you faced while coding this :       No

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.auxilary_stack = []
        self.front = -1
        self.stack_length = 0
        self.auxilary_stack_length = 0

    def push(self, x: int) -> None:
        if self.empty():
            self.front = x
        self.stack1.append(x)
        self.stack_length += 1

    def pop(self) -> int:
        if self.empty():
            return -1
        
        while not self.empty():
            self.auxilary_stack.append(self.stack1.pop())
            self.auxilary_stack_length += 1
            self.stack_length -= 1
        
        
        #print(self.auxilary_stack_length)
        
        popped_element = self.auxilary_stack.pop()
        self.auxilary_stack_length -= 1
        while self.auxilary_stack_length > 0:
            if self.empty():
                self.front = self.auxilary_stack[-1]
            self.stack1.append(self.auxilary_stack.pop())
            self.stack_length += 1
            self.auxilary_stack_length -= 1
        return popped_element

    def peek(self) -> int:
        return self.front

    def empty(self) -> bool:
        if self.stack_length == 0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()