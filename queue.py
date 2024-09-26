# -*- coding: utf-8 -*-
"""
Created on Tue Dec 24 19:48:49 2019

@author: WELCOME
"""

class queue:
    def __init__(self):
        self.queue=[]
    def push(self,data):
        self.queue.append(data)
        print(data)
    def pop(self):
        if len(self.queue)==0:
            print(None)
            return None
        else:
            a=self.queue.pop(0)
            print("Popped Element is",a)
            return "Popped element is" +str(a) 
    def peek(self):
        if len(self.queue)==0:
            print(None)
            return None
        else:
            return self.queue[0]
    def empty(self):
        if len(self.queue)==0:
            print(True)
            return True

queue=queue()        
queue.push(1)



queue.push(2) 



queue.peek();  # returns 1



queue.pop();   # returns 1

queue.pop()

queue.empty(); # returns false
        