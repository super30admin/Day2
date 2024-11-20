"""
// Time Complexity : O(1) for push, peek, and empty method
                        O(n) for pop method
// Space Complexity : O(n + n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


// Your code here along with comments explaining your approach
We do push operation as we do in a stack. For pop in queue, first element is to be removed instead of
last. So, we empty stack1 in a temporary stack in reverse order. i.e. first element from stack1
will be last element in temp_stack. Now, if we do pop operation in temp_stack, we are actually deleting
first element from stack1. After pop operation, we transfer data from temp_stack back to stack1 in same
way.
"""
class MyQueue:

    def __init__(self):
        self.push_stack = []
        # self.pop_stack = []

    def push(self, x: int) -> None:
        #normal push operation.
        self.push_stack.append(x)

    def pop(self) -> int:
        #creating a temp_stack, transfering data, pop from temp_stack, transfer data back to original
        # stack

        print("push_stack before pop", self.push_stack)
        self.pop_stack = []
        while len(self.push_stack) > 0:
            self.pop_stack.append(self.push_stack.pop())
        print(self.pop_stack)

        ans = self.pop_stack.pop()

        while len(self.pop_stack) > 0:
            self.push_stack.append(self.pop_stack.pop())

        print("push_stack after pop", self.push_stack)
        return ans

    def peek(self) -> int:
        #get value where top of stack is present
        print("before peek", self.push_stack)
        if len(self.push_stack) > 0:
            return self.push_stack[0]
        else:
            return None

    def empty(self) -> bool:
        if len(self.push_stack) <= 0:
            return True
        else:
            return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()