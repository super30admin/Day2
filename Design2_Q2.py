# Design a HashSet without using any built-in hash table libraries.
#
# To be specific, your design should include these functions:
#
#     add(value): Insert a value into the HashSet.
#     contains(value) : Return whether the value exists in the HashSet or not.
#     remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
class HashSet:

    def __init__(self):

        self.array=[None for _in range(1000000)]

    def add(self, key):

        if not self.contains(key):
            self.array[key]==True

    def remove(self, key):

        if self.contains(key):

            self.array[key]=None

    def contains(self, key):

        return self.array[key]



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)   
