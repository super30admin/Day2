class MyHashSet:
    '''
    Time complexity : O(1)
    Space complexity: O(maxsize)//O(n)
    approch: maintaing sqrt(maxsize = 10^6) as bucket size so I need to have 1001 buckets of 1000 to store all the value
    
    add : check if bucket is initialized or not, if not initialize it and update the positionm of key as True
    
    contains and remove : in both the case check if the position of givenkey is True or Not and return answer accordingly.
    '''
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset = [None] * 1001

    def add(self, key: int) -> None:
        if self.hashset[key//1000] == None:
            self.hashset[key//1000] = [False] * 1000
        self.hashset[key//1000][key%1000] = True
        

    def remove(self, key: int) -> None:
        if self.hashset[key//1000]:
            if self.hashset[key//1000][key%1000]:
                self.hashset[key//1000][key%1000] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if self.hashset[key//1000]:
            if self.hashset[key//1000][key%1000]:
                return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)