class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here. Initialization 
        """
        self.hashlength = 1001 # Computed as sqrt(1000000) + 1 to accomodate the 0th index
        self.hash = [[False for _ in range(self.hashlength)] for _ in range(self.hashlength)] 

    def get_index(self, key):
        '''get_index Function definition. '''
        return key%self.hashlength, key//self.hashlength

    def add(self, key: int) -> None:
        h,b = self.get_index(key)
        self.hash[h][b] = True

    def remove(self, key: int) -> None:
        h,b = self.get_index(key)
        if self.hash[h][b]:
            self.hash[h][b] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        h,b = self.get_index(key)
        return self.hash[h][b]