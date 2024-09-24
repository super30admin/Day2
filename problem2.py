"Leetcode - 706"
"Optimized way using Hashing & bucket technique" 

"""
- Create a hashmap size using sqrt method to save the space and memory.
- In each functions, iterate over the hashmap to find key & value.
- If found return the value or append the key & value else return -1 if not found. 
"""

class MyHashMap:
    def __init__(self):
        self.size = 1007    #Using prime number size to reduce collisions
        self.buckets = [[] for i in range(self.size)]

    #hash function
    def hash(self, key:int) -> int:
        return key % self.size
    
    #Add function
    def put(self, key:int, value:int) -> None:
        index = self.hash(key)
        bucket = self.buckets[index]

        #iterate over the bucket
        for i, (k, v) in enumerate(bucket):
            if k == key:
                bucket[i] = (key, value)
                return

        bucket.append((key, value))

    #Get function
    def get(self, key:int) -> int:
        index = self.hash(key)
        bucket = self.buckets[index]

        #Iteration
        for k, v in bucket:
            if k == key:
                return v
        return -1
    
    #Remove function
    def remove(self, key:int) -> None:
        index = self.hash(key)
        bucket = self.buckets[index]
        
        for i, (k, v) in enumerate(bucket):
            if k == key:
                bucket.pop(i)
                return




        



