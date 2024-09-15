class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #Initializing list and nested list size with array list having all None value
        self.list_size = 1000;
        self.nested_list_size = 1000;
        self.arr_list = [None for i in range(self.list_size)]

    def hash(self,key):
        #Returns the hash value for index
        return key % self.list_size
    
    def nested_hash(self,key):
        #Returns the nested hash value for index
        return key//self.nested_list_size

    def nested_array(self,bucket):
        
        #If bucket is first bucket add None to the first bucket with 1001 size 
        if bucket == 0:
            return [None for i in range(self.nested_list_size +1)]
        else:
        #Else the size would remain same with all none values ie. 1000
            return [None for i in range(self.nested_list_size)]

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        #initializing bucket and nest_bucket variables for index values
        bucket = self.hash(key)
        nested_bucket = self.nested_hash(key)

        #If there is no value in bucket
        if self.arr_list[bucket] == None:
            #Calling nested array function to inc size of the first bucket
            self.arr_list[bucket] = self.nested_array(bucket)
        
        self.arr_list[bucket][nested_bucket] =True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.hash(key)
        nested_bucket = self.nested_hash(key)
        temp_hash = self.arr_list[bucket]

        #If the array list and nested array list both not empty make the element none
        if temp_hash is not None and self.arr_list[bucket][nested_bucket] is not None:
            self.arr_list[bucket][nested_bucket] = None
                

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        bucket = self.hash(key)
        nested_bucket = self.nested_hash(key)
        temp_hash = self.arr_list[bucket]

        #If no element in Array list return false
        if temp_hash == None:
            return False
        #If element present in nested list return the element
        elif self.arr_list[bucket][nested_bucket] is not None:
            return self.arr_list[bucket][nested_bucket]
        else:
            return False


#Using Nested hashing to implement hashset with Time complexity as O(1).'


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)