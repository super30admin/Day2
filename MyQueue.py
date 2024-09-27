class MyQueue(object):

    def __init__(self):
        self.stack = []
        self.index = 0

    def push(self, x):
        self.stack.append(x)

    def pop(self):
        self.index = self.index + 1
        return self.stack[self.index - 1]

    def peek(self):
        return self.stack[self.index]
        

    def empty(self):
        return self.index == len(self.stack)
        