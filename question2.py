#Time-Complexity: O(1)
#Space-Complexity: O(n)

class MyHashMap:
    
    def __init__(self):
        # choose a prime number
        self.size = 211
        # create a bucket as list of lists to be able to store different keys with the same hash value
        self.bucket_keys = [[] for _ in range(self.size)]   
        # create a bucket as list of lists to be able to store values mapped to the keys     
        self.bucket_values = [[] for _ in range(self.size)]        


    # create a simple hash function using modulo operator
    def hash_func(self, key: int):
        return key % self.size        


    def put(self, key: int, value: int) -> None:
        # index will never be greater than the initial size of the bucket because of modulo operation within hash function
        # so we will never get an index error
        index = self.hash_func(key)
        if not key in self.bucket_keys[index]:
            self.bucket_keys[index].append(key)
            self.bucket_values[index].append(value)
        else:
            val_index = self.bucket_keys[index].index(key)     
            self.bucket_values[index][val_index] = value


    def get(self, key: int) -> int:
        index = self.hash_func(key)
        if key in self.bucket_keys[index]:
            val_index = self.bucket_keys[index].index(key)     
            return self.bucket_values[index][val_index]
        return -1


    def remove(self, key: int) -> None:
        index = self.hash_func(key)
        if key in self.bucket_keys[index]:
            val_index = self.bucket_keys[index].index(key)     
            self.bucket_keys[index].remove(key) 
            del self.bucket_values[index][val_index]