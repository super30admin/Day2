# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach

#create node of linked list
class Node:
    def __init__(self,key):
        self.key = key
        self.next = None

#create hashset
class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.mymod = 1553
        self.myHash = [None] * self.mymod
        
        
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        #if key position not used add to it
        if not self.myHash[key%self.mymod]:
            self.myHash[key%self.mymod] = Node(key)
        else:
        #if key position is used add end of it if key not there else just return
            iterator = self.myHash[key%self.mymod]
            while iterator.next:
                if iterator.key == key:
                    return
                iterator = iterator.next
            if iterator.key == key:
                return
            else:
                iterator.next = Node(key)
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        # if key position not used then key not there
        if not self.myHash[key%self.mymod]:
            return
        # if key in first position delete it
        elif self.myHash[key%self.mymod].key == key:
            self.myHash[key%self.mymod] = self.myHash[key%self.mymod].next
        else:
        # find key and delete it else return
            iterator = self.myHash[key%self.mymod]
            while iterator.next:
                if iterator.next.key == key:
                    iterator.next = iterator.next.next
                    return
                iterator = iterator.next
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        # if key position not used then it doesn't contain this key
        if not self.myHash[key%self.mymod]:
            return False
        elif self.myHash[key%self.mymod].key == key:
        # if first position has the right key return True
            return True
        else:
        # find keya and if fount return True
            iterator = self.myHash[key%self.mymod]
            while iterator.next:
                if iterator.next.key == key:
                    return True
                iterator = iterator.next
        # if not found return False
            return False