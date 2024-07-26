#Approach
# Using two stacks s1-push stack and s2-pop stack 
# add element to s1 whenever new element is there
# when pop happens first pop all elements from s1 (i.e push) and add to s2(pop stack and pop from it)
# Amortised time complexity = O(1)
# space complexity - O(n)
# peek points to last element in pop_stack and first element in push_stack
# length is sum of both stacks 
# Executed on Leetcode



class MyQueue:

    def __init__(self):
        self.s1=[]
        self.s2=[]
        

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        self.peek()
        return self.s2.pop()
        
    def peek(self) -> int:
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]
        

    def empty(self) -> bool:
        return not self.s1 and not self.s2
        
