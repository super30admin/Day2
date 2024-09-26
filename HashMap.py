# Time complexity : O(1)
# Space complexity : O(n)
# Leetcode : Solved and submitted 

class MyHashMap:

    # Intializing the default values
    def __init__(self):
        # Using a prime number to avoid collisons for the same index
        # store (key, value) in the bucket
        self.size = 2069
        self.buckets = [[] for _ in range(self.size)]

    # Checking for the index after passing the key to the function, if index < 0, then no key is present there, so we append, else we
    # insert the values at the given index
    def put(self, key: int, value: int) -> None:
        bucket, index = self.getIndex(key)
        if index < 0:
            bucket.append((key,value))
        else:
            bucket[index] = (key, value)

    # here we again pass the key to the getIndex function to fetch the index value for the key. If index less than 0, then value is not in the list
    # otherwise fetch the element at position 1, which is the value of the key
    def get(self, key: int) -> int:
        bucket, index = self.getIndex(key)
        if index < 0:
            return -1
        else:
            return bucket[index][1]

    # In order to remove the element from the Hashmap, we again calculate the index using the hash function, then again check for the index value
    # return if index < 0, else remove the element from that index position
    def remove(self, key: int) -> None:
        bucket, index = self.getIndex(key)
        if index < 0:
            return
        else:
            bucket.remove(bucket[index])
    
    # Hash function is the modulus of the size which we have taken as the prime number
    def hashKey(self, key):
        return key % self.size
    
    # find the target bucket and index of the key
    # if index > 0, then (key, value) exist
    # if index < 0, then (key, value) not exist
    
    # This index function uses the hash function to find the bucket where the value would go, and get the index
    def getIndex(self, key):
        hashResult = self.hashKey(key)
        bucket = self.buckets[hashResult]
        
        for i, (k, v) in enumerate(bucket):
            if k == key:
                return bucket, i
        
        return bucket, -1
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
