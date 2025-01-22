#Time Complexity: O(1) for all operations (put, get, remove).
#space compexity:O(n) where n is the number of key-value pair in dictionary

class MyHashMap(object):

    def __init__(self):
        #initilize the dictonary
        self.dict = {}
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """ 

        self.dict[key] = value
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        return self.dict.get(key, -1)


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        if key in self.dict:
            del self.dict[key]

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)