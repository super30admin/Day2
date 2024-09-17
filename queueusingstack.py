class MyQueue(object): 
    def __init__(self):
        self.mainstack=[]

    def push(self, x):
        #appending at the back
        self.mainstack.append(x)

    def pop(self):
        #poppping the element from front 
         #since it acts as a list last element would be -1 index
        return self.mainstack.pop(-1)
        
    def peek(self):
        #returning the front element
        #since it acts as a list last element would be -1 index
        return self.mainstack[-1]
        
    def empty(self):
        return len(self.mainstack)==0
    #here this is a python list even if its queue or stack it will be inserted from back and deleted from front.
    
    
    
     # def __init__(self):
#         self.mainstack=[]
#         self.tmpstack=[]

#     def push(self, x):
#         while self.mainstack:
#             self.tmpstack.append(self.mainstack.pop())
#         self.tmpstack.append(x)
#         while self.tmpstack:
#             self.mainstack.append(self.tmpstack.pop())

#     def pop(self):
#         return self.mainstack.pop()
        

#     def peek(self):
#         return self.mainstack[-1]
        

#     def empty(self):
#         return len(self.mainstack)==0

#     def __init__(self):
#         self.mainstack=[]
#         self.tmpstack=[]

#     def push(self, x):
#         while self.mainstack:
#             self.tmpstack.append(self.mainstack.pop())
#         self.tmpstack.append(x)
#         while self.tmpstack:
#             self.mainstack.append(self.tmpstack.pop())

#     def pop(self):
#         return self.mainstack.pop()
        

#     def peek(self):
#         return self.mainstack[-1]
        

#     def empty(self):
#         return len(self.mainstack)==0
