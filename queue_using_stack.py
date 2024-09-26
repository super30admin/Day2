#time complexity: O(n)
#space complexity: O(n)

class MyQueue:

    def __init__(self):
        self.stack_in=[]
        self.stack_out=[]

    def push(self, x):
        self.x=x
        self.stack_in.append(x)

    def pop(self):
        if len(self.stack_out)==0:
            while(len(self.stack_in)!=0):
                popped=self.stack_in.pop()
                self.stack_out.append(popped)
            return self.stack_out.pop()
        else:
            return self.stack_out.pop()
    
    def peek(self):
        if len(self.stack_out)==0:
            while(len(self.stack_in)!=0):
                popped=self.stack_in.pop()
                self.stack_out.append(popped)
            return self.stack_out[-1]
        else:
            return self.stack_out[-1]
        
    def empty(self):
        if len(self.stack_in)==0 and len(self.stack_out)==0:
            return True
        else:
            return False
