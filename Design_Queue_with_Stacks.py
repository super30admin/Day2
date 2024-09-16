# Time Complexity : write/access- O(1) as before, pop front element - O(1) average, O(n) average
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyQueue:
    # Using two stacks. 
    # stack is LIFO hence using single stack will increase TC - to access the front element of the queue we would require removing all elements, access front element and then store back the removed elements
    def __init__(self):
        # stores all push elements
        self.pushStack = []
        # Used to access front element or remove elements to access front element
        self.popStack = []
    
    def push(self, x: int) -> None:
        self.pushStack.append(x)
    
    def pop(self) -> int:
        # first we check if we have elements are present in popStack - the last element here is the required front element, we can pop out if any element exists in this stack 
        if self.popStack:
            return self.popStack.pop()
        # else- transfer all elements to popStack. pop the last element to get the front element
        for i in range(len(self.pushStack)):
            self.popStack.append(self.pushStack.pop())
        return self.popStack.pop()

    def peek(self) -> int:
        # same concept as pop operation. Here we just access - Either last element of popStack or first element of pushStack is your answer!
        if self.popStack:
            return self.popStack[-1]
        if self.pushStack:
            return self.pushStack[0]
        return None

    def empty(self) -> bool:
        # Queue is empty if no element in both stacks
        if not self.popStack and not self.pushStack:
            return True
        return False

    def printList(self):
        print(self.popStack + self.pushStack)

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
obj.push(4)
obj.push(5)
print("Queue: ")
obj.printList()
pop = obj.pop()
print("Queue after pop: ")
obj.printList()
peek = obj.peek()
empty = obj.empty()
print(pop, peek, empty)
