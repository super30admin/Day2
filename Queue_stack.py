
# design a queue using stack

class Stack:

    def __init__(self):
        self.stack=[]

    def push(self, data):
        if type(data)!=type([]):
            data=[data]
        for i in data :
            self._push(i)
    
    def _push(self, data):
        self.stack.append(data)

    def top(self):
        return self.stack[-1]
    
    def return_full_stack(self):
        st=self.stack[:]
        return st
    
    def pop(self):
        self.stack.pop()
    
    def pop_full(self):
        return[self.stack.pop() for i in range(len(self.stack))]
    
    def __len__(self):
        return len(self.stack)
    
    def print_stack(self):
        print(self.stack)
    
class My_Queue:

    def __init__(self):
        self.st1=Stack()
        self.st2=Stack()
        self.front=None

    def push(self, data):
        """
        O(n) -- complexity and space O(n)
        """
        
        if type(data)!=type([]):
            data=[data]
        for i in data:
            self._push(i)

    def _push(self, data):
        if len(self.st1)==0:
            self.st1.push(data)
            self.front=data
        else:
            get_st=self.st1.pop_full()
            self.st2.push(get_st)
            self.st1.push(data)
            self.st1.push(self.st2.pop_full())

    def pop(self):
        self.st1.pop()

        if len(self.st1)!=0:
            self.front=self.st1.top()

    def peek(self):
        return self.front

    def isEmpty(self):
        return len(self.st1)==0

    def print_queue(self):
        self.st1.print_stack()
        
    def peek(self):
        if len(self.st1) != 0:
            self.st2.push(self.st1.pop_full())
            val=self.st2.top()
            self.st1.push(self.st2.pop_full())
            return val
        return None


    
if __name__ == "__main__":
    q=My_Queue()
    q.push([1,2,3,4,5,6])
    q.print_queue()
    print(q.peek())
    print(q.pop())
    q.print_queue()