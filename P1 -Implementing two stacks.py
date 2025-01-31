#Approach: Create two stacks one for input (To add data) and one for output (To Pop or to get Peek)
#Here the time complexity is O(1) and space complexity is O(n)
#Even though time complexity fot the push function will be high when the ouput list is empty, on an average it is O(1)


class MyQueue:

    def __init__(self):
        #Input queue stack
        self.stackInput = []
        #Output queue stack
        self.stackOutput = []

    def push(self, x: int) -> None:
        #Add the element to the end
        self.stackInput.append(x)

    def pop(self) -> int:
        if not self.stackOutput:
            while self.stackInput:
                self.stackOutput.append(self.stackInput.pop())
        return self.stackOutput.pop()
    def peek(self) -> int:
        if not self.stackOutput:
            while self.stackInput:
                self.stackOutput.append(self.stackInput.pop())
        return self.stackOutput[-1]

    def empty(self) -> bool:
        return not self.stackInput and not self.stackOutput
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()