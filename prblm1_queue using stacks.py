class MyQueue(object):
    #in and out stack
    def __init__(self):
        self.s1 = []
        self.s2 = []
    #just push to in stack
    def push(self, x):
        self.s1.append(x)
    #while popping primarily pop from S2, but if S2 is empty, push everything from S1 to S2 and then pop from S2
    def pop(self):
        self.peek()
        return self.s2.pop()
    #same as pop
    def peek(self):
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]        
    #check if both stacks are empty
    def empty(self):
        return not self.s1 and not self.s2
        
#O(N)>>>O(1)>>>amortized time complexity for ppop and peek 
#since only when S2 is empty, then its O(N) as it requires S2 to be filled completely by popping from S1
#O(N)>>maintaining two stacks

