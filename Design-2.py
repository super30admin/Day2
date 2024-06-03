#Design-2
#Explain your approach in three sentences only at top of your code

#Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
#initialized 2 arrays first S1 and S2, checking if there is any element present in S1 if yes then pop and append them to S2, then push new element to S1 and then check if there is anything in S2, if yes then pop it and append it to S1.
#pop function will pop the element, peek returns the last element and empty checks if it is empty.
class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        while self.s1:
            self.s2.append(self.s1.pop())

        self.s1.append(x)

        while self.s2:
            self.s1.append(self.s2.pop())

    def pop(self) -> int:
        return self.s1.pop()

    def peek(self) -> int:
        return self.s1[-1]

    def empty(self) -> bool:
        return not self.s1


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()



#Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)

#First I have set the size of an array and since all the key's are int, 
#I have used the index as key and assigned values to the index directly in put function.
#in get function, returning the value as per the index key and assigning the key to -1 for removing a value

class MyHashMap:

    def __init__(self):
        self.l = [-1]*1000001 

    def put(self, key: int, value: int) -> None:
        self.l[key] = value

    def get(self, key: int) -> int:
        return self.l[key]

    def remove(self, key: int) -> None:
        self.l[key] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)