class Node(object):
    
    def __init__(self,key=None,value=None,next_node=None):
        self.key = key
        self.value = value
        self.next = next_node

class MyHashMap(object):

    def __init__(self):
        self.__buckets = [None]*2069
    
    def __bucket_id(self,key):
        return key % len(self.__buckets)

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        
        buc_id = self.__bucket_id(key)
        node=head=self.__buckets[buc_id]
        
        while node:
            if(node.key==key):
                node.value = value
                return
            node = node.next
        self.__buckets[buc_id]=Node(key,value,head)

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        buc_id = self.__bucket_id(key)
        node = self.__buckets[buc_id]
        
        while(node and node.key!=key):
            node = node.next
            
        if(node is None):
            return -1
        else:
            return node.value

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        buc_id = self.__bucket_id(key)
        head = self.__buckets[buc_id]
        
        prev = None
        node = head
        
        while node:
            if node.key == key:
                if prev is None:
                    self.__buckets[buc_id] = head.next
                else:
                    prev.next = node.next
                return

            prev, node = node, node.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)