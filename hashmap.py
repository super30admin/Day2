'''
// Time Complexity : 
put: O(n)
get: O(n)
remove : O(n)

// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

'''
class MyHashMap(object):

    def __init__(self):
        self.size=1000
        self.buckets=[[] for _ in range(self.size)]
        
    def _hash(self, key):
        return key%self.size
    
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        bucket=self.buckets[self._hash(key)]
        for i, (k,v) in enumerate(bucket):
            if k==key:
                bucket[i]=(key,value)
                return
        bucket.append((key,value))
        
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        bucket=self.buckets[self._hash(key)]
        for i, (k,v) in enumerate(bucket):
            if k==key:
                return v
        return -1
        
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket=self.buckets[self._hash(key)]
        for i, (k,v) in enumerate(bucket):
            if k==key:
                bucket.pop(i)
                return
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)