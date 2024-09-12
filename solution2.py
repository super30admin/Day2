# Time Complexity : put() - > O(size of bucket~constant), get() -> O(1), remove() -> O(1)
# Space Complexity : O(n), where n is unique keys in hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# internal structure is an list of lists where the nested list (Bucket) has a tuple with key,value
class Bucket():
    
    def __init__(self):
        self.bucket=[]
        
    def put(self,key,value):
        # iterating over the bucket mapped to the key 'key'
        found=False
        
        for i, kv in enumerate(self.bucket):
            if kv[0]==key:
                self.bucket[i]=(key,value)
                found=True
        if not found:
            self.bucket.append((key,value))
        
    def get(self,key):
        
        for (k,v) in self.bucket:
            if k==key:
                return v
        return -1
        
    def remove(self,key):
        
        for i, (k,v) in enumerate(self.bucket):
            if k==key:
                del self.bucket[i]
        return -1
        


class MyHashMap:

    def __init__(self):
        # prime number -> less multiples -> less collision while hash resolution
        self.key_space=2069
        # implementation of the hashmap
        self.hash_table=[Bucket() for i in range(self.key_space)]
        

    def put(self, key: int, value: int) -> None:
        # hash function is modulo + array
        hash_key=key%self.key_space
        
        self.hash_table[hash_key].put(key,value)        

    
    def get(self, key: int) -> int:
        
        hash_key=key%self.key_space
        
        return self.hash_table[hash_key].get(key)  
        
        

    def remove(self, key: int) -> None:
        
        hash_key=key%self.key_space
        
        return self.hash_table[hash_key].remove(key)
        

