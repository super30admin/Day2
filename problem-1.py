# Time Complexity of push() is O(1), pop(),peek() is O(n) and overall space complexity is O(n)
#was able to run on leetcode

class MyQueue:
# Initializinf two stacks
    def __init__(self):
        self.stack1=[]
        self.stack2=[]
# Pushing the items in stack1    

    def push(self, x: int) -> None:
        self.stack1.append(x)

# Popping the elements from stack1 into stack2 and popping stack2 element if stack1 is not empty otherwise first appending stack2 elements into stack1

    def pop(self) -> int:
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        temp =self.stack2.pop()
        
        while self.stack2:
            self.stack1.append(self.stack2.pop())
            
        return temp
           
# Popping the elements from stack1 into stack2 and returning top stack2 element if stack1 is not empty otherwise first appending stack2 elements into stack1
    def peek(self) -> int:
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        temp =self.stack2[-1]
        
        while self.stack2:
            self.stack1.append(self.stack2.pop())
            
        return temp
        
# check is stack1 and stack2 both are empty 

    def empty(self) -> bool:
        if not self.stack1 and not self.stack2:
            return True
        else:
            return False