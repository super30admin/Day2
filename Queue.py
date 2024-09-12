# Time Complexity : O(1) for push, O(n) for pop . It is our choice whether we want to make either push or pop costlier.
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# As stacks are LIFO and queues are FIFO, we push all the data into a second stack in a reverse order
# such that the bottom(last) element of second stack is the first one which was originally pushed.
# Then we can pop that bottom element(from second stack) when asked to pop from the front of the queue.

class MyQueue(object):
    def __init__(self):
        self.S1, self.S2 = [], []

    def push(self, x):
        self.S1.append(x)

    def pop(self):
        if not self.S2:
            while self.S1:
                self.S2.append(self.S1.pop())
        return self.S2.pop()

    def peek(self):
        if not self.S2:
            while self.S1:
                self.S2.append(self.S1.pop())
        return self.S2[-1]

    def empty(self):
        return (not self.S1) and (not self.S2) 


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
obj.push(4)
print(obj.pop())
obj.push(5)
print(obj.pop())
print(obj.pop())
print(obj.peek())
print(obj.empty())
print(obj.pop())
print(obj.pop())


#--------------Below solution is using one stack. In practicality, for operations like read,write
#--------------it is better to maintain two stacks so that the single stack is not locked while operations
#--------------are being performed

# class MyQueue:

#     def __init__(self):
#         self.stack=[]
        

#     def push(self, x: int) -> None:
#         self.stack.append(x)

#     def pop(self) -> int:
#         tmp=self.stack[0]
#         del self.stack[0]
#         return tmp
        

#     def peek(self) -> int:
#         return self.stack[0]
        

#     def empty(self) -> bool:
#         if self.stack:
#             return False
#         return True