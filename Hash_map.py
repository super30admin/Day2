#Time complexity is o(1)
#Space complexity is o(1)
class MyHashMap:
    def __init__(self):
        self.size=1000001
        self.array=[-1]*self.size
        
        

    def put(self, key: int, value: int) -> None:
        self.array[key]=value
        

    def get(self, key: int) -> int:
        return self.array[key]

    def remove(self, key: int) -> None:
        self.array[key]=-1