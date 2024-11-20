class MyHashMap(object):
    
    def __init__(self):
        self.size = 10000 #initiating the size
        self.buckets = [[] for _ in range(self.size)] #initiating an array of size mentioned

    def getBucket(self, key):
        return self.buckets[key % self.size]  # here hash function is the 'key%self.size' which gives the index of the element that is returned

    def findIndexOfKey(self, bucket, key):
        for i, (k, v) in enumerate(bucket): #traverse through the array with index and key value pairs(k,v), if k matches with the key given, then the index of the value is returned
            if k == key:
                return i
        return -1 #if index of the key is not found, then -1 is returned

    def put(self, key, value):
        bucket = self.getBucket(key) #this gives the hashed bucket
        index = self.findIndexOfKey(bucket, key) #this gives the index with the assigned key in the bucket
        if index != -1:
            bucket[index][1] = value #if the index of the key is found, just insert the value in the first position
        else:
            bucket.append([key, value]) #else append the key and value inside the bucket

    def get(self, key):
        bucket = self.getBucket(key)
        index = self.findIndexOfKey(bucket, key)
        if index == -1: return -1 #if the index of the key is not found, then return -1
        return bucket[index][1] #else the first position of the index gives the value

    def remove(self, key):
        bucket = self.getBucket(key) 
        index = self.findIndexOfKey(bucket, key)
        if index == -1: return #if the index is not found, return -1
        del bucket[index] #if found, remove the values in that particular index