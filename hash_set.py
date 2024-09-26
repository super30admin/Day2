# Time Complexity : O(n) = 1 
# Space Complexity : O(n) = n
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : I could not come up with a test case that breaks the code, 
# but there was one huge test case on Leetcode that broke this code. I spent too much time on this. I tried to
# implement this using method taught in class yesterday.


# Your code here along with comments explaining your approach
class Node:
    def __init__(self, data=None, next_pointer=None):
        self.data = data
        self.next_pointer = next_pointer
        
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.storage = [[] for x in range(200)]
        

    def add(self, key: int) -> None:
        one = key % 200
        two = key % 500
        if len(self.storage[one]) > two:
            current = self.storage[one][two]
            if current:
                while current.next_pointer:
                    current = current.next_pointer
                current.next_pointer = Node(key)
            else:
                self.storage[one][two] = Node(key)
        else:
            temp_len = len(self.storage[one])
            increase = two - temp_len + 1 
            increase_arr = [None for x in range(increase)]
            increase_arr[-1] = Node(key)
            self.storage[one]+=increase_arr

            
                
    def remove(self, key: int) -> None:
        one = key % 200
        two = key % 500
        if len(self.storage[one]) > two:
            current = self.storage[one][two]
            if not current: return
            if current.data == key:
                self.storage[one][two] = None
            else:
                while current.next_pointer and current.next_pointer.data!=key:
                    current = current.next_pointer
                if current and current.next_pointer and current.next_pointer.data == key:   
                    current.next_pointer = current.next_pointer.next_pointer

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        one = key % 200
        two = key % 500
        if len(self.storage[one]) > two:
            current = self.storage[one][two]
            if not current: return False
            if current.data == key:
                return True
            else:
                while current.next_pointer and current.next_pointer.data!=key:
                    current = current.next_pointer
                if current and current.next_pointer and current.next_pointer.data == key:   
                    return True
        return False


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(10)
obj.add(20)
obj.add(40)
obj.add(300)
obj.add(199)
obj.add(200)
print(obj.contains(502))
print(obj.contains(1002))
print(obj.contains(2002))
obj.add(400)
obj.add(502)
obj.add(1002)
obj.add(2002)
print(obj.contains(502))
print(obj.contains(1002))
print(obj.contains(2002))
print(obj.contains(200))
print(obj.contains(400))
obj.remove(200)
obj.remove(400)
print(obj.remove(502))
print(obj.remove(1002))
print(obj.remove(2002))
print(obj.contains(400))
obj.add(201)
print(obj.contains(500000))
obj.add(500000)
print(obj.contains(500000))
obj.add(999999)

