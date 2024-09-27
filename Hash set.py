# Python3

class MyHashSet:

    def __init__(self):

        self.set_table = []

    def add(self, key):

        if not self.contains(key):
            self.set_table.append(key)

    def remove(self, key):

        try:
            self.set_table.remove(key)
        except:
            pass

    def contains(self, key):

        return key in self.set_table
abcdls


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)