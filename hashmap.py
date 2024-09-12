class MyHashMap(object):
    
    def __init__(self):
        self.hashsize = 10000
        self.list = [[] for _ in xrange(self.hashsize)]
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        res = key % self.hashsize
        tan= self.list[res]
        for record in tan:
            if record[0] == key:
                record[1] = value
                return
        tan.append([key, value])
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        res = key % self.hashsize
        tan = self.list[res]
        for record in tan:
            if record[0] == key:
                return record[1]
        return -1
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        res = key % self.hashsize
        tan = self.list[res]
        for i, record in enumerate(tan):
            if record[0] == key:
                del tan[i]
                return
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)