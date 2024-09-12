# Time Complexity : O(1) for searching and adding
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Used the logic of HashSets in Java and implemented tehir storage using two classes for Buckets and the actual Hashset.

class Bucket:
    def __init__(self):
        self.bucket=[]

    def update(self,key):
        found=False
        for idx,k in enumerate(self.bucket):
            if key==k:
                self.bucket[idx]=k
                found=True
                break
        if not found:
            self.bucket.append(key)

    def get(self,key):
        for k in self.bucket:
            if key==k:
                return True
        return False

    def remove(self,key):
        for idx,k in enumerate(self.bucket):
            if key==k:
                del self.bucket[idx]


class MyHashSet:
    def __init__(self):
        self.keyspace=2096
        self.hashtable=[]
        for _ in range(self.keyspace):
            self.hashtable.append(Bucket())
    
    def add(self,key):
        hashkey=key%self.keyspace
        self.hashtable[hashkey].update(key)

    def remove(self,key):
        hashkey=key%self.keyspace
        self.hashtable[hashkey].remove(key)

    def contains(self,key):
        hashkey=key%self.keyspace
        return self.hashtable[hashkey].get(key)

hashSet=MyHashSet()
hashSet.add(1)
hashSet.add(2)
print(hashSet.contains(1))
print(hashSet.contains(3))
hashSet.add(2)
print(hashSet.contains(2))
hashSet.remove(2)  
print(hashSet.contains(2))


        