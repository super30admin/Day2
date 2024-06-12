# Time Complexity : O(1) for push & empty | O(n) for pop & peek
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class MyQueue:
    def __init__(self):
        self.inQueue = []
        self.outQueue = []     

    def push(self, x: int) -> None:
        self.inQueue.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outQueue.pop()
    
    def peek(self) -> int:
        if len(self.outQueue) == 0:
            while len(self.inQueue) != 0:
                self.outQueue.append(self.inQueue.pop())
        return self.outQueue[-1]

    def empty(self) -> bool:
        return not self.inQueue and not self.outQueue   


if __name__ == "__main__":
    obj = MyQueue()
    obj.push(4)
    print(obj.pop())
    obj.push(9)
    obj.push(7)
    obj.push(99)
    print(obj.peek())
    print(obj.empty())

