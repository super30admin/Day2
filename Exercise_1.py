""" Time Complexity :    
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : while returning the top element i was returning self.peek in the peek function but after a little brainstorming I realized that I have to return the last element if i am calling a peek operation for pop i need it only to fill the second stack and the peek() in pop just does that and not remove the element here i am removing the first element by the default pop() function for list in python. 
I can do one more thing, which he store the value from peek in one function and then return it but this will only insert one unnecessary line 


// Your code here along with comments explaining your approach """

class MyQueue:
    
    def __init__(self) -> None: # this is the constuctor for this class
        self.Stack1 = [] #I am declaring two stacks for every object of class MyQueue 
        self.Stack2 = []

    def push(self, x : int) -> None :
        self.Stack1.append(x) # every push operation will add the element in the Stack1 1st element's index will always be 0 for stack1 and later the elements will be added


    def peek(self, x : int) -> int:
        if not self.Stack2: # this will check if our 2nd stack is empty or not, if it is empty it will append all the values in the second stack, this way the 0th element will be at the last position of Stack2, this way FIFO concept will be implemented correctly
            while self.Stack1: #this checks for presence of elements in the first stacks, this whill hold true as long as there is an element in the 
                self.Stack2.append(self.Stack1.pop())

        return self.Stack2[-1] #this line will work for both the cases 1. when Stack2 is Empty 2. When Stack2 has elements for second case the if block won't execute

    def pop(self, x : int ) -> int :
        self.peek() # we are only calling this method for filling the Stack2 and getting the proper element at the top of the Stack
        return self.Stack2.pop() # this inbuild method for list will return the top element 

    def isEmpty(self) -> bool :
        return len(self.Stack1)==0 and len(self.Stack2)==0
