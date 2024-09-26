class solution:
    def __init__(self):
        self.queue = []
    
    def push(self, x):
        self.queue.append(x)
    
    def pop(self):
        if self.queue:
            self.queue.pop(0)

    def peek(self):
        if self.queue:
            return self.queue[0]
    
    def empty(self):
        return len(self.queue)==0
