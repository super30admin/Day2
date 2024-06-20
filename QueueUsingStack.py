# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class QueueUsingStack:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, value):
        self.stack1.append(value)

    def pop(self):
        if len(self.stack2) == 0:
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())
        popped_value = self.stack2[-1]
        self.stack2.pop()
        return popped_value

    def peek(self):
        if len(self.stack2) == 0:
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    def empty(self):
        if len(self.stack1) == 0 and len(self.stack2) == 0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
obj = QueueUsingStack()
obj.push(10)
obj.push(20)
obj.push(30)
obj.push(40)
print("Popped", obj.pop())
obj.push(50)
print("Popped", obj.pop())
print("Popped", obj.pop())
print("Popped", obj.pop())
print("Top Value: ", obj.peek())
print(obj.empty())

