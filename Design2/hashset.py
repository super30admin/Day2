#Time Complexity: O(1) for contain
#Space Complexity: O(n)
#Did this code successfully run on leetcode:
#Any problem you faced while coding thing:
class MyHashSet:
    #exactly like a hashmap,but with boolean values

    def __init__(self):
        self.buckets=1001
        self.bucketitems=1000
        self.data=[None]*self.buckets

    def add(self, key: int) -> None:
        index_1=key%self.buckets
        index_2=int(key/self.bucketitems) #double hasing
        if self.data[index_1] is None:
            self.data[index_1]=[None]*self.bucketitems
        self.data[index_1][index_2]=True


    def remove(self, key: int) -> None:
        index_1=key%self.buckets
        index_2=int(key/self.bucketitems) #double hasing
        if self.data[index_1] is not None:
            self.data[index_1][index_2]=None


    def contains(self, key: int) -> bool:
        index_1=key%self.buckets
        index_2=int(key/self.bucketitems) #double hasing
        if self.data[index_1] is not None and self.data[index_1][index_2] is not None:
            return True
        return False

        
