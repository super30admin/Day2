# Time Complexity :O(N) for inserting and O(1)
# Space Complexity :O(2N)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class Queue:
    def __init__(self):
        self.s1 = []
        self.s2 = []
 
    def push(self, x):
        while len(self.s1) != 0:
            self.s2.append(self.s1[-1])
            self.s1.pop()
        self.s1.append(x)

        while len(self.s2) != 0:
            self.s1.append(self.s2[-1])
            self.s2.pop()
    def pop(self):
        if len(self.s1) == 0:
            print("Q is Empty")
        x = self.s1[-1]
        self.s1.pop()
        return x
 

if __name__ == '__main__':
    ele = Queue()
    ele.push(8)
    ele.push(7)
    ele.pop()
    ele.push(9)
 
    print(ele.pop())
    print(ele.pop())
    