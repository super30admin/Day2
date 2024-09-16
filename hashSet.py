#Time complexity: O(n)
#Space complexity: O(n): Based on the number. In the worst case its O(n)
#approach: Allocated a array  of size 10*3 and all the none in them. as we pass the value in add function. we add values in them. as we pass value in remove function we remove the values
# and for contains we check the whole array and then return the respective output if the key is present or not.
class MyHashSet:

    def __init__(self):
        self.array = [[] for _ in range(1000)]
        
        

    def add(self, key: int) -> None:
        keyIn = key % 1000
        if not self.contains(key):
            self.array[keyIn].append(key)
        

    def remove(self, key: int) -> None:
        keyIn = key % 1000
        if self.contains(key):
            self.array[keyIn].remove(key)
        

    def contains(self, key: int) -> bool:
        keyIn = key % 1000
        return key in self.array[keyIn]




h = myHashSet()
h.add(1)
h.add(2)
print(h.contains(1))
print(h.contains(3))
print(h.contains(2))
h.remove(2)
print(h.contains(2))
