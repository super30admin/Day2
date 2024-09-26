class Queue:
    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x):
        self.s1.append(x)

    def pop(self):
        self.peek()
        return self.s2.pop()

    def peek(self):
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]

    def empty(self):
        return not self.s1 and not self.s2

if __name__ == '__main__':
    q = Queue()
    q.push(1)
    q.push(4)
    q.push(3)
    print(q.pop())
    print(q.pop())
    print(q.pop())
    print(q.empty())