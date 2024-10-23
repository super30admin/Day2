"Time Complexity is O(1) on average for put, get, and remove operations. But in  worst case (when there are many collisions and elements are stored in the same bucket), the time complexity can go to O(N), where N is the number of elements in the hash map."
"Space Complexity is O(N)"

#Explanation
"We first inittate a primary data structure lists here with the length of root of maximum value"
"Secondary datastructre chosen here is lists again, which will directly help us append, or get a value in average of O(1) times"

class MyHashMap:

    def __init__(self):
        self.buckets = [None] * 1000

    def put(self, key: int, value: int) -> None:
        primaryidx = key % len(self.buckets)

        if self.buckets[primaryidx] is None:
            self.buckets[primaryidx] = []

        for i, (k,v) in enumerate(self.buckets[primaryidx]):
            if key == k:
                self.buckets[primaryidx][i] = (key, value)
                return
        self.buckets[primaryidx].append((key,value))   

    def get(self, key: int) -> int:
        primaryidx = key % len(self.buckets)

        if self.buckets[primaryidx] is None:
            return -1
        
        for k ,v in self.buckets[primaryidx]:
            if key == k:
                return v
        
        return -1
        

    def remove(self, key: int) -> None:
        primaryidx = key % len(self.buckets)

        if self.buckets[primaryidx] is None:
            return -1
        
        for i, (k,v) in enumerate(self.buckets[primaryidx]):
            if key == k:
                self.buckets[primaryidx].remove(self.buckets[primaryidx][i])
        
        return -1
        