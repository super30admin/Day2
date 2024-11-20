#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Aug 26 10:53:43 2021

@author: ameeshas11
"""

#Time Complexity : O(n)
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
    
from Collections import deque

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #initialize two stacks using deque
        self.stack1 = deque()
        self.stack2 = deque()

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        #append in primary stack
        self.stack1.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        #if secondary stack is already filled just pop the topmost element
        #if secondary stack is empty fill it by popping elements from primary stack and then return topmost
        if self.stack2:
            return self.stack2.pop()
        else:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            return self.stack2.pop()
        
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        #if secondary stack is already filled just return the topmost element value
        #if secondary stack is empty fill it by popping elements from primary stack and then return topmost value
        if self.stack2:
            return self.stack2[-1]
        else:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            return self.stack2[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        #if any one stack is not empty return False
        if self.stack1:
            return False
        elif self.stack2:
            return False
        else:
            return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()