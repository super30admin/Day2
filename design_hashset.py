class Bucket:
    def __init__(self):
        self.list_elements = []
    def update(self, key):
        for key_val in self.list_elements:
            if key_val == key:
                return
        self.list_elements.append(key)
    
    def contains(self, key):
        for key_val in self.list_elements:
            if key_val == key:
                return True
        return False
    
    def remove(self, key):
        for index, key_val in enumerate(self.list_elements):
            if key_val == key:
                del self.list_elements[index]
                return

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #Space Coplexity = O(M+K) where K is no of buckets and M is number of unique values in set
        self.hash_bucket_width = 9973
        self.hash_set = [Bucket() for i in range(self.hash_bucket_width)]
        

    def add(self, key: int) -> None:
        #Time Comlexity -> O(M/K) (M is Total number of unique elements and K is size of bucket)
        hash_index = key%9973
        self.hash_set[hash_index].update(key)
        

    def remove(self, key: int) -> None:
        #Time Comlexity -> O(M/K) (M is Total number of unique elements and K is size of bucket)
        hash_index = key%9973
        self.hash_set[hash_index].remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        #Time Comlexity -> O(M/K) (M is Total number of unique elements and K is size of bucket)
        hash_index = key%9973
        return self.hash_set[hash_index].contains(key)
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)