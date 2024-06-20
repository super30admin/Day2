'''
Time Complexity 
push --> O(1)
pop --> O(1) avg case
peek --> O(1) avg case
emty --> O(1)

Space Complexity
we require 2 stacks so O(n) 

Approach
pushing will append values directly to stack1.
on pop or peek at first time push the elements to stack2 so for the first time time complexity will be O(n)
peek will give the top element of the stack2
pop will pop out the elemnt from stack2
'''

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        
        

    def push(self, x: int) -> None:
        self.stack1.append(x)
        
        

    def pop(self) -> int:
        if len(self.stack2)==0:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            
        #print(self.stack2)
        val = self.stack2.pop()
        #print(self.stack2)
        return val
        

    def peek(self) -> int:
        #print(self.stack2)
        #return self.stack2[-1]
        if len(self.stack2)==0:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]
        

    def empty(self) -> bool:
        if len(self.stack1)==0 and len(self.stack2)==0:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()