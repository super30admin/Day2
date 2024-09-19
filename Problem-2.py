class Node:
    def __init__(self, key,value):
        self.key = key
        self.value= value
        self.next = None


class MyHashMap:

    def __init__(self):
        self.size =  10000
        self.hash=[None]*(self.size)

    def search(self,key:int) -> Node:
        hash_value = (key % self.size)
        prev = None
        temp = self.hash[hash_value]

        while temp!=None:
            if temp.key ==key:
                break
            prev = temp
            temp = temp.next
        return prev



    def put(self, key: int, value: int) -> None:
        hash_value = key%self.size
        if self.hash[hash_value] ==  None:
            node = Node(-1,-1)
            self.hash[hash_value] = node

        prev = self.search(key)
        if prev.next ==None:
            node = Node(key,value)
            prev.next = node
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        hash_value = key % self.size
        if self.hash[hash_value]==None:
            return -1
        prev = self.search(key)
        if prev.next == None:
            return -1
        else:
            return prev.next.value


    def remove(self, key: int) -> None:
        hash_value = key % self.size
        if self.hash[hash_value] == None:
            return None
        prev = self.search(key)
        if prev.next == None:
            return None
        else:
            prev.next = prev.next.next

myHashMap = MyHashMap()
myHashMap.put(1, 1) # The map is now [[1,1]]
myHashMap.put(2, 2) #The map is now [[1,1], [2,2]]
myHashMap.get(1)    # return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3)    # return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1) # The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2)    # return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2) # remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2)    # return -1 (i.e., not found), The map is now [[1,1]]
