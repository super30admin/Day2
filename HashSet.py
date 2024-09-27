class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.storage = [([False] * 1000), ([False] * 1000)]
        # self.storage = [],[]
        self.buckets = 1000
        self.bucketItems = 1001

    def bucket(self, key):
        return (key // self.buckets)

    def bucketItem(self, key):
        return (key % self.bucketItems)

    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)

        if self.storage[bucket][bucketItem] == False:
            self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)

        if self.storage[bucket][bucketItem] == True:
            self.storage[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)

        if self.storage[bucket][bucketItem] == True:
            return True
        else:
            return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)


"""
Code is running on Leetcode and is being accepted.
However, submission failing with below error:

IndexError: list index out of range
    if self.storage[bucket][bucketItem] == False:
Line 22 in add (Solution.py)
    result = obj.add(
Line 57 in __helper_select_method__ (Solution.py)
    ret.append(__DriverSolution__().__helper_select_method__(method, params[index], obj))
Line 109 in _driver (Solution.py)
    _driver()
Line 118 in <module> (Solution.py)


Note sure how to fix this.


"""