#implement queue using stacks 
#approach 1 : using two stacks 
class MyQueue(object):

    def __init__(self):
        self.st1 = []
        self.st2 = []

    def push(self,x):
        self.st1.append(x)

    def pop(self):
        if len(self.st2) == 0:
            while len(self.st1)!=0:
                ele = self.st1[-1]
                self.st2.append(ele)
                self.st1.pop()
        
        return self.st2.pop()

    def peek(self):
        if len(self.st2) == 0:
            while len(self.st1)!=0:
                ele = self.st1[-1]
                self.st2.append(ele)
                self.st1.pop()
        return self.st2[-1]
    def empty(self):
        if len(self.st1) == 0 and len(self.st2) == 0:
            return True
        return False
        

object1 = MyQueue()
object1.push(1)
object1.push(2)
print(object1.peek())
print(object1.pop())
print(object1.empty())