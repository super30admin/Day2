// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap:

    def __init__(self):
        self.size = 100
        # each bucket is a list of pairs
        self.buckets = [[] for i in range(self.size)]
        
    def put(self, key: int, value: int) -> None:
        pairs = self.buckets[key % self.size]
        for i, (k, v) in enumerate(pairs):
            if k == key:
                pairs[i]=(key, value)
                return
        else:
            pairs.append((key, value))
        
    def get(self, key: int) -> int:
        pairs = self.buckets[key % self.size]
        for (k, v) in pairs:
            if k == key:
                return v
        else:
            return -1
            
    def remove(self, key: int) -> None:
        pairs = self.buckets[key % self.size]
        for i, (k, v) in enumerate(pairs):
            if k == key:
                # deleting ith is O(n) cost, so lets 
                # move the last one to i-th, and remove the last in O(1)
                pairs[i] = pairs[-1]
                if i < len(pairs):  # do not pop() if i was the last pair
                    pairs.pop()
                return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)