class Bucket:
    def __init__(self):
        self.bucketlist = []

    def updatebucket(self, key):
        for _idx, kv in enumerate(self.bucketlist):
            if key == kv:

                return
        self.bucketlist.append(key)

    def getbucketvalue(self, key):
        for _id, kv in enumerate(self.bucketlist):
            if kv == key:
                return kv
        return -1

    def remove(self, key):
        for id, kv in enumerate(self.bucketlist):
            if kv== key:
                del self.bucketlist[id]
        return


class hashusingL:
    def __init__(self):
        self.size = 1000
        self.bucket = [Bucket() for _idx1 in range(self.size)]

    def gethash(self, key):
        newkey = hash(key)
        return newkey % self.size

    def put(self, key):
        current_bucket_index = self.gethash(key)
        self.bucket[current_bucket_index].updatebucket(key)

    def get(self, key):
        current_bucket_index = self.gethash(key)
        return self.bucket[current_bucket_index].getbucketvalue()

    def remove(self, key):
        current_bucket_index = self.gethash(key)
        self.bucket[current_bucket_index].remove(key)

    def getitems(self):
        result = []
        for bucketblock in self.bucket:
            if len(bucketblock.bucketlist) > 0:
                result.append(bucketblock.bucketlist)
        return result


class node:
    def __init__(self, key, Next=None):
        self.key = key
        self.Next = None


class hashsetusingList:
    def __init__(self):
        self.size = 1000
        self.bucket = [None] * self.size

    def getitems(self):
        result = []
        for bucket1 in self.bucket:
            similar_hash_list = []
            while bucket1 is not None:
                similar_hash_list.append((bucket1.key))
                bucket1 = bucket1.Next
                result.append(similar_hash_list)

        return result

    def put(self, key):
        hashkey = self.gethashkey(key)
        current_bucket = self.bucket[hashkey]
        if current_bucket == None:
            self.bucket[hashkey] = node(key)
            return
        else:
            current_iterable = current_bucket
            while current_iterable:
                if current_iterable.key == key:
                    return
                else:
                    current_iterable = current_iterable.Next
            current_iterable = node(key)

    def gethashkey(self, key):
        newkey = hash(key)
        return newkey % self.size

    def get(self, key):
        hashkey = self.gethashkey(key)
        current_bucket = self.bucket[hashkey]
        if current_bucket is None:
            return
        while current_bucket:
            if current_bucket.key == key:
                return current_bucket.key
            current_bucket = current_bucket.next
        return

    def remove(self, key):
        hashkey = self.gethashkey(key)
        current_bucket = self.bucket[hashkey]
        if current_bucket is None:
            return
        if current_bucket.key == key:
            self.bucket[hashkey] = None
        while current_bucket.Next:
            if current_bucket.Next.key == key:
                current_bucket.Next = current_bucket.Next.Next
                return
            else:
                current_bucket = current_bucket.Next
        return


class executor:
    if __name__ == '__main__':
        hashobject = hashsetusingList()
        list =[123,789,90,899,8789,'sunil','sunil']
        for key1 in list:
            hashobject.put(key1)
        print(hashobject.getitems())
        hashobject.remove(789)
        print(hashobject.getitems())

        hashobject = hashusingL()
        list = [123, 789, 90, 899, 8789, 'sunil', 'sunil']
        for key in list:
            hashobject.put(key)

        print(hashobject.getitems())
        hashobject.remove(789)
        print(hashobject.getitems())










