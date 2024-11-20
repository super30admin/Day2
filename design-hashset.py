"""
Runtime Complexity:
1) O(1) - the function add(), contains(), remove(), all are done by hashing the key. We declare a custom data structure [[]] to perform our operations. 
When adding a new key to the set, we hash the key and store that key in thar particular hashed index. In this case, we check if the spot is empty and create one or if it's
not empty then we just append the key. Append and inserting in non contiguous memory location takes O(1). Same time is taken for delete() as well because we just remove the 
element from the hashed index. Contains() just checks whether the key is present in the hashset are not and returns true or false respectively.

Space Complexity- O(1) as well.
Yes, the code worked on leetcode.
"""



class MyHashSet:

    def __init__(self):
        self.bucketlength = 199
        self.hashset = [[]]*self.bucketlength
        
    def hash(self,key):
        return key % self.bucketlength

    def add(self, key: int) -> None:
        bucket_index= self.hash(key)
        if not self.hashset[bucket_index]:
            self.hashset[bucket_index] = [key]
        else:
            self.hashset[bucket_index].append(key)
        
        

    def remove(self, key: int) -> None:
        bucket_index= self.hash(key)
        if key in self.hashset[bucket_index]:
            while key in self.hashset[bucket_index]:
                self.hashset[bucket_index].remove(key)

    def contains(self, key: int) -> bool:
        bucket_index= self.hash(key)
        return key in self.hashset[bucket_index]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
