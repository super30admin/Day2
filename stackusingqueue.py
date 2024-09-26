# Time Complexity : for all functions O(1) because there's not search or complex thing like that
# Space Complexity : I dont know how to calculate space complexity, here i assume it's O(2n) because we have
# two queues, then again i feel like it's O(1) for no reason. 
# Did this code successfully run on Leetcode :
#  Any problem you faced while coding this :
class MyQueue(object):

    def __init__(self):
        self.inQueue = []
        self.outQueue = []

    def push(self, x):
        self.inQueue.append(x)   

    def pop(self):
        self.peek()
        return self.outQueue.pop()

    def peek(self):
        if not self.outQueue:
            while(self.inQueue):
                self.outQueue.append(self.inQueue.pop())
            else:
                print("main stack is empty")
        return self.outQueue[-1]

    def empty(self):
        return not self.inQueue and not self.outQueue

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()