"""
## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.

pop() -- Removes the element from in front of queue.

peek() -- Get the front element.

empty() -- Return whether the queue is empty.

# we create two stacks, stack 1 is for push operatiom. stack is for pop or peek operation, to check empty we need to check if both stacks are empty


"""
class Queue:
    def __init__(self):     #  Initialise
        self.S1=[]
        self.S2=[]

    def push(self,x):   # push into queue means push into S1
        self.S1.append(x)

    def pop(self):   # for pop check if S2 is empty, pop will be done from S2. if yes then move element from S1 to S2 and then pop
        if len(self.S2)==0:
            while len(self.S1) !=0:
                self.S2.append(self.S1.pop())
        return self.S2.pop()

    def peek(self):       # return front element in queue , same as pop
        if len(self.S2)==0:
            while len(self.S1) !=0:
                self.S2.append(self.S1.pop())
        return self.S2[-1]

    def empty(self):        # if not stacks s1 and s2 are emprty then queue is empty
        if len(self.S1)==0 and len(self.S2)==0:
            return True
        else:
            return False


if __name__ == "__main__":
    obj = Queue()
    obj.push(4)
    print(obj.pop())
    obj.push(9)
    obj.push(7)
    obj.push(99)
    print(obj.peek())
    print(obj.empty())