class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.dict_ = {}
        

    def add(self, key: int) -> None:
        
        if not (key in self.dict_):
            self.dict_[key] = True

    def remove(self, key: int) -> None:
        
        if(key in self.dict_):
            del self.dict_[key]

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        
        if(key in self.dict_):
            return True
        
        return False
