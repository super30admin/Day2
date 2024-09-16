class two_stacks_queue:
    def __init__(self):
        self.s1=[]
        self.s2=[]
    def push(self,val):
        self.s1.append(val)
    def pop(self):
        if (self.s1 == [] and self.s2 == []) :
            return -1
        else:
            if not self.s2:
                while len(self.s1):
                    self.s2.append(self.s1.pop())
                return self.s2.pop()
            else:
                return self.s2.pop()
    def peek(self):
        if not self.s1:
            return self.s2[len(self.s2)-1]
        else:
            while len(self.s1):
                self.s2.append(self.s1.pop())
            return self.s2[len(self.s2)-1]
    def isempty(self):
        return (self.s1 == [] and self.s2 == [])

j= two_stacks_queue()
j.push(10)
j.push(20)
j.push(30)
j.push(40)
j.push(50)
j.push(60)
print(j.pop())
print(j.pop())
print(j.peek())
print(j.pop())










