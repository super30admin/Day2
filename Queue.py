
class MyQueue(object):
    def __init__(self):
        
        self.stack1 = list()
        self.stack2 = list()
        
    def push(self, x):
        
        self.stack1.append(x)
        self.stack2 = list()
        for i in self.stack1[::-1]:
            self.stack2.append(i)
        
    def pop(self):
        
        peek = self.stack2.pop()
        self.stack1 = list()
        for i in self.stack2[::-1]:
            self.stack1.append(i)
        return peek
    def peek(self):
       
        return self.stack2[-1]
        
    def empty(self):
        
        return len(self.stack1) == 0
'''
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()