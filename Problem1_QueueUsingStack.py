#Time Complexity: O(n) for all operations
#Space Complexity: O(n) 
#Working on LeetCode: Yes (Will optimize to O(1))


class MyQueue:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []
    
    def push(self, data):
        self.stack1.append(data)
    
    def pop(self):
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        
        ans = self.stack2.pop()

        while self.stack2:
            self.stack1.append(self.stack2.pop())
        
        return ans

    def peek(self):
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        
        ans = self.stack2[-1]

        while self.stack2:
            self.stack1.append(self.stack2.pop())

        return ans
    
    def empty(self):
        if not self.stack1 and not self.stack2:
            return True
        return False
    

if __name__ == "__main__":
    my_obj = MyQueue()
    my_obj.push(1)
    my_obj.push(2)
    print(my_obj.peek())
    print(my_obj.pop())

