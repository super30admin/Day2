class MyHashSet:
    def __init__(self):
        self.bucket = [[] for i in range(1000)]

    def add(self, key : int) :
        val = key%1000
        if key not in self.bucket[val]:
            self.bucket[val].append(key)

    def remove(self, key : int) :
        if key in self.bucket[val]:
            self.bucket[val].remove(key)

    def contains(self, key : int) -> bool :
        val = key%1000
        if key in self.bucket[val]:
            return True

        else:
             return False