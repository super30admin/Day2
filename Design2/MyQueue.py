#Time Complexity: O(1) for pop
#Space Complexity: O(n)
#Did this code successfully run on leetcode: yes
#Any problem you faced while coding thing:

class MyQueue:
    '''
    A queue is first in first out
    main idea: we will have two stacks, we start adding in the first stack. When we pop and the second stack is empty,
    we fill in the second stack by poping one by one first stack. So the first element in is now at the top of the second stack (first out)
    then when we pop we always take from second stack and when we push, in first stack. Time complexity averages out to 0(1)
    '''

    def __init__(self):
        self.stack=[]
        self.to_empty=[]

    def push(self, x: int) -> None:
        self.stack.append(x)


    def pop(self) -> int:
        if not self.to_empty :
            while self.stack:
                self.to_empty.append(self.stack.pop())
        return self.to_empty.pop()


    def peek(self) -> int:
        if not self.to_empty:
            return self.stack[0]
        return self.to_empty[-1]



    def empty(self) -> bool:
        if not self.to_empty and not self.stack:
            return True
        return False
       
