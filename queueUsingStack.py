class MyQueue:

    def __init__(self):
        self.arr=[]
        self.arr1=[]

    def push(self, x: int) -> None:#time O(1) and Space O(1)
        self.arr.append(x)

    def pop(self) -> int:#Time  O(n) and space O(1)
        if len(self.arr1)==0 :
            while len(self.arr)!=0:
                self.arr1.append(self.arr.pop())
        return self.arr1.pop()

    def peek(self) -> int:#Time  O(n) and space O(1)
        if len(self.arr1)==0 :
            while len(self.arr)!=0:
                self.arr1.append(self.arr.pop())
        return self.arr1[-1]

    def empty(self) -> bool:#Time  O(1) and space O(1)
        return not self.arr and not self.arr1



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
