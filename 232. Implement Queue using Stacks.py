# Implement two stacks, one acts as our initial data structure to handle push operations
# once pop or peek command comes, we move over our elements from stack one to stack two
# once elements are at the back of stackTwo, we can peek() or pop() elements in O(1) time

# Example
# Stack One = [1,2,3,4,5]
# Stack Two = []

# pop()

# Stack One = []
# Stack Two = [5,4,3,2]  (1 gets removed)

class MyQueue:

    def __init__(self):
        self.stackOne = []
        self.stackTwo = []

    def push(self, x: int) -> None:
        self.stackOne.append(x)

    def pop(self) -> int:
        
        if not self.stackTwo:
            while(self.stackOne):
                self.stackTwo.append(self.stackOne.pop())

        
        return self.stackTwo.pop()

    def peek(self) -> int:
        if not self.stackTwo:
            while(self.stackOne):
                self.stackTwo.append(self.stackOne.pop())
        return self.stackTwo[-1]

    def empty(self) -> bool:
        if len(self.stackOne) == 0 and len(self.stackTwo) == 0:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
