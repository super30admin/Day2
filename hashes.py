//Yes
//None

//Code
class MyHashSet:

    def __init__(self):
        self.s=set()

    def add(self, key: int) -> None:
        self.s.add(key)

    def remove(self, key: int) -> None:
        if key in self.s:
            self.s.remove(key)

    def contains(self, key: int) -> bool:
        if(key in self.s):
            return True
        return False
