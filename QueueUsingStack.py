// Time Complexity : avg - O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyQueue(object)

    def __init__(self)
        
        Initialize your data structure here.
        
        self.ins = []
        self.out = []

    def push(self, x)
        
        Push element x to the back of queue.
        type x int
        rtype None
        
        self.ins.append(x)

    def pop(self)
        
        Removes the element from in front of queue and returns that element.
        rtype int
        
        if(len(self.out) ==0)
                for i in range(len(self.ins))
                    self.out.append(self.ins.pop())
        return self.out.pop()

    def peek(self)
        
        Get the front element.
        rtype int
        
        if (len(self.out) == 0)
            for i in range(len(self.ins))
                self.out.append(self.ins.pop())
        return self.out[-1]

    def empty(self)

        
        Returns whether the queue is empty.
        rtype bool
        
       
        return ((len(self.out) ==0) & (len(self.ins)==0))
