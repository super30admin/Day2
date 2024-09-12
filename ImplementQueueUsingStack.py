#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Nov 19 08:43:41 2019

@author: tanvirkaur
"""

# Average Time complexity = O(1) 
# Worst Time complexity = O(n)
# space complexity = O(n)
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stackIn = []
        self.stackOut = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stackIn.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        # if stackout is empty we fill it with all the elements of the stackin and then pop out from the stackout
        if len(self.stackOut) == 0:
            while len(self.stackIn) !=0:
                y =  self.stackIn.pop()
                self.stackOut.append(y)
            return self.stackOut.pop()
        else:
            return self.stackOut.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.stackOut) ==0:
            while len(self.stackIn) !=0:
                y =  self.stackIn.pop()
                self.stackOut.append(y)
            return self.stackOut[-1]
        else:
            return self.stackOut[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.stackOut) == 0 and len(self.stackIn) == 0:
            return True