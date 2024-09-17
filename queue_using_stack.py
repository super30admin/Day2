'''
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
'''
class MyQueue:

    def __init__(self):
        self.stack = []
        self.stackTemp = []
    
    '''
    For Push operation
    Time complexity : O(n)
    Space complexity : O(n)
    '''
        
    def push(self, x: int) -> None:
        while not self.empty():
            self.stackTemp.append(self.stack.pop())
        
        self.stack.append(x)
        
        while(len(self.stackTemp) != 0):
            self.stack.append(self.stackTemp.pop())
    
    '''
    For Pop operation
    Time complexity : O(1)
    Space complexity : O(1)
    '''
    def pop(self) -> int:
        return self.stack.pop()
    
    '''
    To check element on the top of the queue
    Time complexity : O(1)
    Space complexity : O(1)
    '''
    def peek(self) -> int:
        return self.stack[-1]
    
    '''
    To check if queue is empty
    Time complexity : O(1).
    Space complexity : O(1)
    '''
    def empty(self) -> bool:
        return True if len(self.stack) == 0 else False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()