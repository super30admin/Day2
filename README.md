# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.instack = []
        self.outstack = []
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.instack.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.outstack.pop()
            
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if self.outstack == []:
            while self.instack != []:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]
        
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.instack == [] and self.outstack == []:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()


## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

class MyHashSet:
    def __init__(self):
        self.size = 10 * 1024
        self.elems = [[] for _ in range(self.size)]

    def add(self, key: int) -> None:
        index = key % self.size
        if key not in self.elems[index]:
            self.elems[index].append(key)

    def remove(self, key: int) -> None:
        index = key % self.size
        if key in self.elems[index]:
            self.elems[index].remove(key)

    def contains(self, key: int) -> bool:
        index = key % self.size
        return key in self.elems[index]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)




