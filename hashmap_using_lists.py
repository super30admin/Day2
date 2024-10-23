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
        