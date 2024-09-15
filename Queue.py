# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class MyQueue:
    def __init__(self):
        #initialize two empty stack one for push and another for pop
        self.s1 = []
        self.s2 = []

    def push(self, x):
        #pushing all elements in 1st stack
        self.s1.append(x)

    def pop(self):
        #here chechking whether stack is empty
        if self.empty():
            return None
        #s2 not empty then poping out first element from s2
        elif self.s2:
            return self.s2.pop()
        #s2 is empty then appeding all elements from s1 to s2
        #then poping from s2
        else:
            while self.s1:
                self.s2.append(self.s1.pop())
            return self.s2.pop()

    def peek(self):
        #same as pop but just returning top most element from s2
        result = self.pop()
        self.s2.append(result)
        return result   

    def empty(self):
        if self.s1 == [] and self.s2 == []:
            return True
        return False


q = MyQueue()
q.push(1)
q.push(2)
q.push(3)
q.push(4)
print(q.pop())
print(q.pop())
print(q.pop())
print(q.empty())
print(q.peek())

