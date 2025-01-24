"""
//Time Complexity : 
Problem 1 --> O(1) Amortized as push operation takes O(1) but pop operation can go upto the last element.
// Space Complexity :
Problem 2 --> O(n) as we store all the elements
// Did this code successfully run on Leetcode :
Yes the solution ran successfully. For Problem 2 not all cases passed (SUGGEST HERE)
// Any problem you faced while coding this :
Tried to create a search function as follows:
    def search(Node(self.head), key): 
        #Return the previous node to the current key that we are looking for
        MyNode(self.prev) = MyNode(self.head)
        MyNode(self.current) = MyNode(self.head.next)
        while current != None and current.key != key:
            prev = current
            current = current.next
        return prev
Got SYNTAX ERROR for Node(self.head). Please suggest here !!!!
"""
'''// Your code here along with comments explaining your approach'''
#Problem 1 - Implement queue using stacks
#If the first stack is empty we will continue to push data into it. However, when we do the pop operation
# we will transfer the elements to the second stack in reversed order so that the front of the queue is 
# either removed or returned for peek and pop as expected.
class MyQueue(object):

    def __init__(self):
        self.data_stack = [] #initialize 2 empty stacks
        self.element_stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.data_stack.append(x) #Append the data stack that is empty

    def pop(self):
        """
        :rtype: int
        """
        if len(self.element_stack) == 0: #Transfer elements of data stack in reverse order 
            while len(self.data_stack) != 0:
                self.element_stack.append(self.data_stack.pop())
        return self.element_stack.pop() 
    #Since order of elements is reversed the front of the queue is removed

    def peek(self):
        """
        :rtype: int
        """
        
        if len(self.element_stack) == 0: #Transfer elements of data stack in reverse order
            while len(self.data_stack) != 0:
                self.element_stack.append(self.data_stack.pop())
        n = len(self.element_stack) - 1
        return self.element_stack[n] 
    #As the order of the elements in the stack are reversed and stored the front of the queue
    # is returned as expected.

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.data_stack) == 0 and len(self.element_stack) == 0 
    #Check if both stacks are empty and return "false" else "true"

#Problem 2 - Design a Hashmap without using in-built libraries
# Create a class Node with key, value and next. Create a Storage array and a hashing function.
# Put/Get/Remove operation we search for the key and return value or else we continue to search
# If we don't find the element "Null" is returned
class MyNode:
    def __init__(self, key = -1, value = -1, next = None):
        self.key = key
        self.value = value
        self.next = next

class MyHashMap:

    def __init__(self): #Create an array of pointers with size 10^4
        self.Storage = [MyNode() for i in range(10000)]
    
    def hashfunction(self, key): 
        #Create the hashing function - modulo that returns the same 
        # value consistently
        return key % len(self.Storage)

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        index = self.hashfunction(key)
        #If linked list exists check for the key    
        current = self.Storage[index]
        while current.next != None:
            #if the next node is not empty then update the value
            if current.next.key == key:
                current.next.value = value
            return               
            #if the next node is empty then add a new node
            current = current.next
        current.next = MyNode(key, value)
        
    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        index = self.hashfunction(key)
        current = self.Storage[index]
        #Get the key that we are searching and return the value
        while current:
            if current.key == key:
                return current.value
            current = current.next 
        #update current to next pointer until node is found    
        return -1
        #If the node is not found return -1
        
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hashfunction(key) 
        #get the index from the hash function
        current = self.Storage[index]
        while current.next:
            if current.next.key == key:
                current.next = current.next.next
            #If key is found update the pointer to the next pointer and return
                return
            current = current.next #Update the current node to continue searching