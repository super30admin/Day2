#time complexity: O(1)
#space complexity: O(1)
class MyHashSet:

    def __init__(self):
        self.buckets=1000
        self.bucketItems=1000
        self.hashset=[None]*self.buckets
        
    def getbucket(self, key):
        self.key=key
        return key%self.buckets
    
    def getbucketitems(self, key):
        self.key=key
        return key//self.bucketItems

    def add(self, key):
        self.key=key
        bucket_no=self.getbucket(key)
        bucketitem_no=self.getbucketitems(key)
        
        if self.hashset[bucket_no]==None:
            if bucket_no==0:
                self.hashset[bucket_no]=[None]*(self.bucketItems+1)
            else:
                self.hashset[bucket_no]=[None]*(self.bucketItems)
                
        self.hashset[bucket_no][bucketitem_no]=True
                

    def remove(self, key):
        self.key=key
        bucket_no=self.getbucket(key)
        bucketitem_no=self.getbucketitems(key)
        
        if self.hashset[bucket_no]==None:
            return
        
        else:
            self.hashset[bucket_no][bucketitem_no]=False

    def contains(self, key):
        self.key=key
        bucket_no=self.getbucket(key)
        bucketitem_no=self.getbucketitems(key)
        
        if self.hashset[bucket_no]==None:
            return
        else:
            return self.hashset[bucket_no][bucketitem_no]
