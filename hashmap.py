#Time Complexity = O(1)
#Space Complexity = O(n)
#Ran successfully on LC
#No problems were faced as such

 def __init__(self):
        self.hashmap = {} #define hashmap
        

    def put(self, key: int, value: int) -> None:
        self.hashmap[key] = value #key value mapping

    def get(self, key: int) -> int:
        if key in self.hashmap:
            return self.hashmap[key] #if key is found, return value
        else:
            return -1

    def remove(self, key: int) -> None:
        if key in self.hashmap:
            del self.hashmap[key] #if key is found, delete the key