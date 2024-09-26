class ListNode:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None


class MyHashSet(object):

    def __init__(self):
        self.size = 1000
        self.hash = [None]*self.size
        """
        Initialize your data structure here.
        """
        

    def add(self, key):
        index = key%self.size
        #If the node at given index is None then set it with given key
        if self.hash[index] == None:
            self.hash[index] = ListNode(key,True)
        else:
            currNode = self.hash[index]
            #If there are nodes at given index then traverse the linked-list and attach the key at the end.
            tempHead = currNode
            self.hash[index] = ListNode(key,True)
            self.hash[index].next = currNode
        """
        :type key: int
        :rtype: None
        """
        

    def remove(self, key):
        index = key%self.size
        #If node at given index is None then do nothing. 
        if self.hash[index] == None:
            return
        #Otherwise find given key in the linked-list at current index and set its value to False.
        else:
            currNode = self.hash[index]
            while currNode:
                if currNode.key == key:
                    currNode.val = False
                    break
                currNode = currNode.next
        """
        :type key: int
        :rtype: None
        """
        

    def contains(self, key):
        index = key%self.size
        #If there's no linked-list at given index then return False.
        if self.hash[index] == None:
            return False
        #Otherwise traverse the linked-list to check if the desired element is present and its value is True.
        else:
            currNode = self.hash[index]
            while currNode:
                if currNode.key == key:
                    if currNode.val == True:
                        return True
                    else:
                        return False
                currNode = currNode.next
            return False

        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """