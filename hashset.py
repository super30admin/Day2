class MyHashSet(object):

    def __init__(self):
        self.set1 = set()        

    def add(self, key):
        self.set1.add(key)
        

    def remove(self, key):
        if key in self.set1:
            self.set1.remove(key)
        

    def contains(self, key):
        if key in self.set1:
            return True
        return False