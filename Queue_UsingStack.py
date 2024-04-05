# Time Complexity : O(1) for Push. O(n) for Pop and Peek
# Space Complexity : O(1) for Push. O(n) for Pop and Peek
# Did this code successfully run on Leetcode: I ran this code in VS Code editor in my local machine
# Any problem you faced while coding this: No

class MyQueue(object):

    def __init__(self):
        self.in_stack = []
        self.out_stack = []
        self.curr = -1
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.curr+=1
        self.in_stack.append(x)
        

    def pop(self):
        """
        :rtype: int
        """

        self.popper = len(self.out_stack)
        if self.popper == 0: #If out_Stack is empty, push all in_stack elements into out_stack. Otherwise pop from out_stack. 
            while self.curr > -1:
                self.out_stack.append(self.in_stack[self.curr])
                self.in_stack.pop()
                self.popper +=1
                self.curr -=1
        return self.out_stack.pop() 
        

    def peek(self):
        """
        :rtype: int
        """
        self.popper = len(self.out_stack)
        if self.popper == 0: #when out_stack is empty, push all in_stack elements into out_stack. Else, return top of out_stack
            while self.curr >=0:
                self.out_stack.append(self.in_stack.pop())
                self.curr-=1
        return self.out_stack[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        self.popper = len(self.out_stack)

        if self.popper ==0: #If out_Stack is empty, return in_stack is empty or not. Otherwise return False
            return len(self.in_stack) == 0
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
print("Peeked: ", obj.peek())
print("Popped: ", obj.pop())
print("Empty?: ", obj.empty())
# obj.push(1)
# obj.push(2)
# obj.push(3)
# print("Popped: ", obj.pop())
# obj.push(4)
# obj.push(5)
# obj.push(6)
# print("Popped: ", obj.pop())
# print("Popped: ", obj.pop())
# print("Popped: ", obj.pop())
# print("Peeked: ", obj.peek())
# print("Empty?: ", obj.empty())
# print("Popped: ", obj.pop())
# print("Popped: ", obj.pop())
# print("Empty?: ", obj.empty())
