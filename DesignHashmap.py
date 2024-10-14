class MyHashMap:
    class Node:
      def __init__(self, key= None, value =None, next= None):
        self.key = key
        self.value = value
        self.next = next

    def find(self, head, key):
      prev = None
      curr = head
      while curr != None and curr.key != key:
        prev = curr
        curr = curr.next
      return prev, curr
    
    def Hash_func(self, key):
      return key % 10000

    def __init__(self):
      self.storage = [None] * 10000

    def put(self, key: int, value: int) -> None:
      hash_value = self.Hash_func(key)

      if self.storage[hash_value] == None:
        self.storage[hash_value] = self.Node(-1,-1, None) #initiating a dummy Node
      prev, curr = self.find(self.storage[hash_value], key)
      if curr == None:
        prev.next = self.Node(key, value) #Inserting new Node
      else:
        curr.value = value #Updating the exixting value

    def get(self, key: int) -> int:
      hash_value = self.Hash_func(key)
      if self.storage[hash_value] == None:

        return -1
      else:
        prev, curr = self.find(self.storage[hash_value], key)
        if curr != None:
          return curr.value
        else:
          return -1

    def remove(self, key: int) -> None:
      hash_value = self.Hash_func(key)
      if self.storage[hash_value] == None:
        return 
      prev, curr = self.find(self.storage[hash_value], key)
      if curr == None:
        return
      prev.next = curr.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)