class MyHashSet(object):
#double hashing to avoid collision problem of modifying the same boolean array space
#ensures uniqueness
    def __init__(self):
        """
        Initialize your data structure here.
        """
        ##design buckets of arrays
        self.buckets=1000
        #(#sqroot of given range)
        self.bucketitems=1000
        #(#so that square of (10^3) becomes entire range to hold all items)
        self.storage=[None]*self.buckets
        #its gonna be boolean array as we dont need to store actual value anytime, just indicate if value is present or not
        
        
            
    def add(self,key):
        hash1=key%self.buckets
        hash2=key//self.buckets
        if self.storage[hash1]==None:
            #if bucket index is empty, initialize it with array of bucketitems and make it 2d array
            self.storage[hash1]=[None]*self.bucketitems
        #make true for particular index in array in bucket of that index
        self.storage[hash1][hash2]=True

    def remove(self, key) :
        hash1=key%self.buckets
        hash2=key//self.buckets
        if self.storage[hash1]==None:
            #if bucket index is empty, just return as we know that is already empty
            return
        #enter False for that index
        self.storage[hash1][hash2]=False
            

    def contains(self, key) :
        """
        Returns true if this set contains the specified element
        """
        hash1=key%self.buckets
        hash2=key//self.buckets
        if self.storage[hash1]==None:
            #if bucket index is empty, just return false as we know that is already empty
            return False
        #return T/F whatever is stored at that index
        return self.storage[hash1][hash2]

#O(1) for all operations(directly accessing array indices)
#O(range) space as we need to maintain constant bucket size with completed arrays as children





# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)