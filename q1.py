from collections import deque
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Not any problem specific
class MyQueue:

    def __init__(self):
        '''For implementing we need two stacks''' 
        #This is the actual stack does the push
        self.inp=deque()
        #print(self.inp)
        #This is the additional stack which is used for pop but make it easy
        self.out=deque()
        #print(self.out)
        
    '''Time complexity is O(1)'''
    def push(self, x: int) -> None:
        self.inp.append(x)
        #print(self.inp,self.out)

    '''Amortized time complexity is O(1), But worst case time complexity O(N), Where N is number of elements in the queue'''
    def pop(self) -> int:
        if(len(self.out)!=0):
            val=self.out[-1]
            self.out.pop()
        else:    
            l=len(self.inp)
            #First move the elements from s1 to s2 
            for i in range(l):
                self.out.append(self.inp[-1])
                self.inp.pop()
            #Just remove the top element
            val=self.out[-1]
            self.out.pop()
            
        #print(self.inp,self.out)    
        return val

    '''Amortized time complexity is O(1), But worst case time complexity O(N), Where N is number of elements in the queue'''
    def peek(self) -> int:
        if(len(self.out)!=0):
            val=self.out[-1]
        else:
            l=len(self.inp)
            #First move the elements from s1 to s2 
            for i in range(l):
                self.out.append(self.inp[-1])
                self.inp.pop()
            #Just remove the top element
            val=self.out[-1]
        
        #print(self.inp,self.out)
        return val

    '''Time Complexity is O(1)'''
    def empty(self) -> bool:
        if((len(self.inp)==0) and (len(self.out)==0)):
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()