# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue(object):

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        self.isEmpty = True
        self.isStack1Empty = True   

    def push(self, x):
        self.stack1.append(x)
        if len(self.stack1) == 1:
            self.isEmpty = False
            self.isStack1Empty = False
        

    def pop(self):
        if len(self.stack2) == 0:
            if len(self.stack1) != 0:
                index = 0
                while index < len(self.stack1):
                    self.stack2.append(self.stack1.pop())
                self.isStack1Empty = True
            else:
                self.isEmpty = True
                return
        if self.isStack1Empty == True and len(self.stack2) == 1:
            self.isEmpty = True
        return self.stack2.pop()


    def peek(self):
        x = self.pop()
        self.stack2.append(x)
        self.isEmpty = False
        return x
        

    def empty(self):
        return self.isEmpty
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()