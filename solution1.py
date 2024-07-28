class MyQueue(object):

    def __init__(self):
        self.inp = []
        self.out = []

    def push(self, x):
        self.inp.append(x)
        print("pushed and now inp is: ", self.inp)
        

    def pop(self):
        if len(self.out) == 0:
            while not self.empty():
                self.out.append(self.inp.pop())

        p = self.out.pop()

        while len(self.out) != 0:
            self.inp.append(self.out.pop())
        print("peeked: ", p)
        return p

    def peek(self):
        if len(self.out) == 0:
            while not self.empty():
                self.out.append(self.inp.pop())

        p = self.out[len(self.out) - 1]

        while len(self.out) != 0:
            self.inp.append(self.out.pop())
        print("peeked: ", p)
        return p

    def empty(self):
        if len(self.inp) == 0:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()