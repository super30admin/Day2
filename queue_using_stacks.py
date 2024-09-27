'''
T.C: O(1) - push, pop, peek
S.C: O(N)
'''

class MyQueue:

    def __init__(self):
        self.f_list = list()
        self.s_list = list()
        

    def push(self, x: int) -> None:
        self.f_list.append(x)


    def pop(self) -> int:
        self.peek()
        if self.empty():
            return -1
        return self.s_list.pop()
        

    def peek(self) -> int:
        if not self.s_list:
            while self.f_list:
                self.s_list.append(self.f_list.pop())
        
        return self.s_list[-1] if self.s_list else -1
        

    def empty(self) -> bool:
        if not self.f_list and not self.s_list:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()