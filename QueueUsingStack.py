#Time complexity O(1)- Average case
#Space complexity O(n)
class MyQueue(object):

    def __init__(self):
        self.stack_in = []
        self.stack_out = []

    def push(self, x):
        self.stack_in.append(x)
        return None
        

    def pop(self):
        if self.empty():
            return None
        if not self.stack_out:
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())
        return self.stack_out.pop()

    def peek(self):
        if self.empty():
            return None
        if not self.stack_out:  # If stack_out is empty, transfer elements
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())
        return self.stack_out[-1]
    
    def empty(self):
        if len(self.stack_in) == 0 and len(self.stack_out) == 0:
            return True
        else:
            return False
        

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()