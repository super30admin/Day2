# Did this code successfully run on Leetcode : YES

# Approach
# implementation follows discussion in class
# double hashing: first hashing function is modulo, second is division
# good bucket size is square root of expected key range (given as 0 - 10^6 in Leetcode)


class MyHashSet:

	def __init__(self):
		"""
		Initialize your data structure here.
		SC: O(1)
		"""
		self.buckets = 1000
		self.inner_buckets = 1000
		self.storage = [None]*self.buckets

	def add(self, key: int) -> None:
		"""
		Add element to hashset
		determine outer and inner indices using first and second hashing functions respectively
		TC: O(n)
		SC: O(n)
		---------
		arguments:
		key: int, value to add in hashset
		"""
		outer_index = key % self.buckets
		inner_index = key // self.inner_buckets
		if not self.storage[outer_index]:
			if outer_index == 0:
				self.storage[outer_index] = [False]*(self.inner_buckets+1)
			else:
				self.storage[outer_index] = [False]*self.inner_buckets
		self.storage[outer_index][inner_index] = True
		

	def remove(self, key: int) -> None:
		"""
		delete key from hashset
		since keeping track using boolean, just setting it to False
		TC: O(1)
		----------
		arguments:
		key: int, value to remove from hashset
		"""
		outer_index = key % self.buckets
		inner_index = key // self.inner_buckets
		if self.storage[outer_index]:
			if self.storage[outer_index][inner_index]:
				self.storage[outer_index][inner_index] = False

	def contains(self, key: int) -> bool:
		"""
		Returns true if this set contains the specified element
		----------
		arguments:
		key: int, value to check in hashset
		----------
		returns:
		exists: bool, True if key exists in hashset else False
		"""
		outer_index = key % self.buckets
		inner_index = key // self.inner_buckets
		if self.storage[outer_index]:
			return self.storage[outer_index][inner_index]
		else:
			return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)