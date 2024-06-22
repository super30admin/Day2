"""
Implement queue using stacks
TC - O(1)
SC - O(N)
Approach: 
create 2 stacks, 
In to store all pushed elements
If pop method is called and out stack is empty then copy from IN to OUT newest element first, until IN is empty.
THEN return the last element from the OUT stack to fulfil FIFO condition of a queue.

If more elements are pushed keep adding to IN, IF pop is called then return last element from OUT.

Once OUT is empty, repeat.

"""



class MyQueue:

    def __init__(self):
        self.In = []
        self.Out = []


    def push(self, x: int) -> None:
        self.In.append(x)


    def pop(self) -> int:
        self.peek()
        return self.Out.pop()


    def peek(self) -> int:
        if not self.Out:
            while self.In:
                self.Out.append(self.In.pop())
        return self.Out[-1]

    def empty(self) -> bool:
        return not self.In and not self.Out
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()