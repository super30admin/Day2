Time complexity all operations are O(1).

class MyHashSet(object):

    def __init__(self):
        self.array = [None]*1000

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        hashed_key = key % 1000
        double_hashed = key //1000
        if hashed_key == 0 and self.array[hashed_key] == None:
            self.array[hashed_key] = [False]*1001
            self.array[hashed_key][double_hashed] = True
            
        elif self.array[hashed_key] == None:
            self.array[hashed_key] = [False]*1000
            self.array[hashed_key][double_hashed] = True
        else:
            self.array[hashed_key][double_hashed] = True
            
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hashed_key = key % 1000
        double_hashed = key // 1000
        if(self.array[hashed_key] != None):
            self.array[hashed_key][double_hashed] = False
        
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        hashed_key = key % 1000
        double_hashed = key //1000
        if(self.array[hashed_key] != None):
            return self.array[hashed_key][double_hashed] == True
        return False
