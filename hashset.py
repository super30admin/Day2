# Time Complexity : O(1) - still not sure how to calculate it but there seems no loops
# Space Complexity : O(n) - still not sure how to calculate it but in contains function there is python
# " in " keyword whose time complexity is O(n)
# Did this code successfully run on Leetcode : well yes
# Any problem you faced while coding this : A LOT. I've my exams and s30 classes going on simultaneously 
# so i couldn't focus too much in the classes. I'm not from english background and newbie in python 
# it took me 3-4 days to realise what is hashmap, hash functions, hash set. I've watched many solutions 
# for the same problem, most time took me was to figuring out what is happening after each line is executed
# I constantly printout and debug the code to understand the structure better.'
# It'd be great if we discuss the python or javascript solutions too

class MyHashSet(object):

    def __init__(self): 
        self.storage = [[] for _ in range(1000)]
        
    def bucketItem(self, key): return key % 1000
    
    def add(self, key):
        if not self.contains(key):
            self.storage[self.bucketItem(key)].append(key)

    def remove(self, key):
        if self.contains(key):
            self.storage[self.bucketItem(key)].remove(key)
    
    def contains(self, key):
        print(self.storage)
        return key in self.storage[self.bucketItem(key)]

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
# for _ in range(100000): obj.add(_)
obj.add(5466)
obj.add(7864775466)
obj.add(5467)
obj.add(54656)
obj.add(9466)
# obj.add(5465)
# obj.add(5466)
# print(obj.storage)
print(obj.contains(5466))
# print(obj.contains(5465))
# print(obj.contains(5467))
# obj.remove(key)
# param_3 = obj.contains(key)