class MyHashMap(object):

    def __init__(self):
        self.size = 1000
        self.bucket = [[] for _ in range(self.size)]

        
    def _has(self,key):
        return key % self.size
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        index = self._has(key)
        for i,(k,v) in enumerate (self.bucket[index]):
            if k == key:
                self.bucket[index][i] =(key, value)
                return
        self.bucket[index].append((key,value))

        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        index = self._has(key)
        for k,v in self.bucket[index]:
            if k == key:
                return v 
        return -1

        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self._has(key)
        for i, (k,v) in enumerate (self.bucket[index]):
            if k ==key:
                del self.bucket[index][i]
                return

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
