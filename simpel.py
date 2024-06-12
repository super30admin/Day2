def __init__(self):
    self.stack1 = []
    self.stack2 = []

def push(self, x):
    self.stack1.append(x)

def pop(self):
    if self.empty():
        return None
    
    if not self.stack2: 
        for i in range(len(self.stack1)):
            self.stack2.append(self.stack1.pop())
        return self.stack2.pop()
        
    else:
        return self.stack2.pop()
    

def peek(self):
    res = self.pop()
    self.stack2.append(res)
    return res
    

def empty(self):
    return (not self.stack1) and (not self.stack2)