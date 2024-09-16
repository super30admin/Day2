# Time Complexity: O(n)
# Space complexity: O(n)

class MyQueue:

    def __init__(self):  # two stack approach
        self.inn = []
        self.out = []

    def push(self, x: int) -> None:  # simply append in innStack
        self.inn.append(x)

    def pop(self) -> int:
        self.peek()
        return self.out.pop()

    def peek(self) -> int:               # transfer inn stack elements to out stack elements until inn stack becomes empty
        if not self.out:                 # if out stack is empty
            while self.inn:              # while inn stack has elements, pop from the top and append in out stack
                self.out.append(self.inn.pop())

        return self.out[-1]               # return top of out stack

    def empty(self) -> bool:              # check is Empty
        return not self.inn and not self.out

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()