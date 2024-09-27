#Time Complexity - 0(1) SC - O(n). BUt n is constant so O(1) .  constant time
class MyHashSet(object):
	def __init__(self):
		"""
		Initialize your data structure here.
		"""
		self.hashSet = [None] * 1000
		self.buckets = 1000
		self.bucketItems = 1000

	def add(self, key):
		"""
		:type key: int
		:rtype: None
		"""
		i = self.hashfunc1(key)
		if self.hashSet[i] == None:
			self.hashSet[i] = [None] * self.bucketItems
		j = self.hashfunc2(key)
		self.hashSet[i][j] = True


	def remove(self, key):
		"""
		:type key: int
		:rtype: None
		"""
		i = self.hashfunc1(key)
		if self.hashSet[i] == None:
			return
		j = self.hashfunc2(key)
		self.hashSet[i][j] = False


	def contains(self, key):
		"""
		Returns true if this set contains the specified element
		:type key: int
		:rtype: bool
		"""

		i = self.hashfunc1(key)
		j = self.hashfunc2(key)
		return self.hashSet[i] != None and self.hashSet[i][j]

	def hashfunc1(self, value):
		return value % self.buckets

	def hashfunc2(self, value):
		return value // self.bucketItems
