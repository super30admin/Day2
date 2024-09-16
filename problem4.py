#hash set:
"" " add(value): Insert a value into the HashSet. contains(value) : Return whether the value exists in the HashSet or not. " ""
"" " remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing. " ""

class hashset:
    def __init__(self,hash_size): #intitalising the hashing range
        self.hash_size=hash_size
        self.set=[[]]*self.hash_size
    def hashvalue(self,value): #finding hash value
        hash=value%self.hash_size
        return hash
    def insert(self,value): # O(1)
        #print(value)
        self.ins_indx = self.hashvalue(value)
        self.set[self.ins_indx] = [True]
        #print(self.set[self.ins_indx])
        #if not self.set[self.ins_indx]:
        #    self.set[self.ins_indx]=[value]
        #else:
        #    self.set[self.ins_indx].append(value)
        #self.set[self.hashvalue(value)].append(value)
        #print(self.set)
    def remove(self,value): # O(1)
        self.k=self.hashvalue(value)
        if self.set[self.k] == []:
            return -1
        else:
            self.set[self.k]=[]
            return ("removed",value)


            #return (self.set[self.k])

    def contains(self,value):  #O(1)
        self.k = self.hashvalue(value)
        if self.set[self.k] == []:
            return ("does not contain", value)
        else:
            return ("contains",value)




kj=hashset(1000000)
kj.insert(23)
kj.insert(11)
kj.insert(12)
kj.insert(13)
kj.insert(14)
kj.insert(15)
print(kj.contains(12))
print(kj.contains(23))
print(kj.remove(14))
print(kj.contains(14))

