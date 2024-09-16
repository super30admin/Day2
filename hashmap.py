#My input did not go through all test cases

class Node:
    
    def __init__(self, data = None):
        
        self.data = data
        self.next = None
        

class LinkedList:
    
    def __init__(self):
        
        self.head = None
        self.node = None
        
    def push(self, value):
        
        if(self.head == None):
            
            self.node = Node(value)
            self.head = self.node
            
        else:
            
            temp = Node(value)
            self.node.next = temp
            self.node = temp
            
    def remove(self, value):
        
        current_node = self.head
        
        while(current_node):
            
            previous_node = current_node
            
            if(current_node.data == value):
                
                if(current_node == self.head):

                    return_value = self.current_node.data
                    self.head = current_node.next
                    return return_value
                    
                    
                else:
                    return_value = current_node.data
                    previous_node.next = current_node.next
                    return return_value
                    
            else:
                
                current_node = current_node.next
                
        return -1

 
    def find(self, value):
        
        current_node = self.head
        
        while(current_node):
            
            previous_node = current_node
            
            if(current_node.data == value):
                
                return current_node.data
            
            else:
                
                current_node = current_node.next
                
        return -1
            
  

           
class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hash = [None for i in range(100)]
        
        

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        
        temp = key % 10
        
        self.hash[temp] = LinkedList()
        
        self.hash[temp].push(value)
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        
        temp = key%10
        
        if(self.hash[temp] == None):
            
            return -1
        
        else:
            
            return self.hash[temp].find(key)
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        
        temp = key % 10
        
        if(self.hash[temp] == None ):
            
            return -1
        
        else:
            
            return self.hash[temp].remove(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)