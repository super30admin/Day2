# Time complexity for add, remove and contains: O(1)
#Space complexity for add, remove and contains: O(1)
# ~~~ I was able to run this code successfully on leetcode ~~~ #
class MyHashSet:

    def __init__(self):
        #initializing buckets for creating array and bucket items for creating nested array
        self.buckets=1000  
        self.bucketitems=1000
        self.array=[None for i in range(self.buckets)] #Primary array

    def add(self, key: int) -> None:
        bucketrowindex=key % self.buckets #1st hash function
        bucketcolindex=key//self.bucketitems #2nd hash function
        if self.array[bucketrowindex]==None: #if the primary array index is empty
            if bucketrowindex==0: #edge case: if key=1000000 then we will need an extra column/extra index in secondary array as the range of 1000 is 0 to 999 
                #but we will need the 1000th index hence adding +1
                self.array[bucketrowindex]=self.bucketitems+1
            else:
                #for all other key values we are initiating secondary/nested array with same size
                self.array[bucketrowindex]=self.bucketitems
            #We are initiating nested/secondary array with boolean value false
            self.array[bucketrowindex]=[False for i in range(self.array[bucketrowindex])]
        #returning true as we have filled the index
        self.array[bucketrowindex][bucketcolindex]=True

    def remove(self, key: int) -> None:
        bucketrowindex=key % self.buckets
        bucketcolindex=key//self.bucketitems
        # Just changing to False will remove the key
        if self.array[bucketrowindex]!=None:
            self.array[bucketrowindex][bucketcolindex]=False
        
        
    def contains(self, key: int) -> bool:
        bucketrowindex=key % self.buckets
        bucketcolindex=key//self.bucketitems
        #Returns true if that index is found to be true
        return self.array[bucketrowindex]!=None and self.array[bucketrowindex][bucketcolindex]==True
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)