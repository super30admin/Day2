# Time Complexity :
# push operation: O(1)
# pop oeration: amortized O(1)
# peek operation: amortized O(1)
# empty operation: O(1)

# Space Complexity : O(n) to store in 2 stacks
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Nope


# Your code here along with comments explaining your approach

# I took 2 stacks and push the numbers into instack
# and then when i need to pop i need to do fifo so for that i push all the elements in instack to outstack 
# inorder to pop the first element (I did this procedure in peek as it will return the first element I need)
# do this instack to outstack only if outstack is empty so shifting elements in not done always
# hence the time complexities are amortized O(1) for the operations


class MyQueue:

    def __init__(self):
        self.instack = [] #input stack
        self.outstack = [] #output stack

    def push(self, x: int) -> None:
        self.instack.append(x) #pushing numbers to instack
        

    def pop(self) -> int:
        self.peek() #peek to get the first numbr in the outstack which will be at the end of the list
        return self.outstack.pop() # perform pop
        
    def peek(self) -> int:
        if not self.outstack: # if the outstack is empty
            while self.instack: #put all numbrs in instack to outstack
                self.outstack.append(self.instack.pop())
        return self.outstack[-1] #get the last number in outstack which is fifo
        

    def empty(self) -> bool:
        return not self.instack and not self.outstack #check if both the stacks are empty and return 
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()