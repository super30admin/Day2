
#Implementing primary array and a secondary array at each index of primary array
#the values of secondary array will be boolean- gives O(1) search,remove,add


class MyHashSet:

    def __init__(self):
        #initialize a array of size 1000
        
        self.array=[None for i in range(1000)]
        self.buckets=1000
        self.bucketitems=1000
        

    def add(self, key: int) -> None:
        '''O(1) Time complexity
           O(1) Space complexity'''
        #first hash
        key1=key%self.buckets
        #second hash
        key2=key//self.bucketitems
        #check if element at key1 is None(no secondary array)
        if self.array[key1]==None:
            #if primary array index is one(edge case for valye=10^6)
            if key1==0:
                self.array[key1]=[False for i in range(1001)]
            else:
                self.array[key1]=[False for i in range(1000)]
        #set the value to boolean 
        self.array[key1][key2]=True
        

    def remove(self, key: int) -> None:
        '''O(1) Time complexity
           O(1) Space complexity'''
        key1=key%self.buckets
        key2=key//self.bucketitems
        if self.array[key1]:
            if self.array[key1][key2]==True:
                self.array[key1][key2]=False
            
        
        

    def contains(self, key: int) -> bool:
        '''O(1) Time complexity
           O(1) Space complexity'''
        key1=key%self.buckets
        key2=key//self.bucketitems
        if self.array[key1]==None:
            return False
        
        return self.array[key1][key2]
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)