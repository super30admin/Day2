# // # Design-2

# // ## Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)

# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :  no




class MyHashMap:
	class Node(object):

		def __init__(self, key, val):

			self.key = key

			self.val = val

			self.next = None



	def __init__(self):

		self.Hashlist = [None] * 10000

	

	# value will always be non-negative

	def put(self, key, value):

		i = self.find_index(key)

		if self.Hashlist[i] == None:

			self.Hashlist[i] = self.Node(-1, -1)

		prev_node = self.find_node(self.Hashlist[i], key)

		if prev_node.next == None:

			prev_node.next = self.Node(key, value)

		else:

			prev_node.next.val = value



	# Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key

	def get(self, key):

		i = self.find_index(key)

		if self.Hashlist[i] == None:

			return -1

		prev_node = self.find_node(self.Hashlist[i], key)

		# why should we check for this condition again because node.next would never be none if self.Hashlist[i] is not none

		# And the length of our horizontal list is either zero or minimum two nodes right

		return -1 if prev_node.next == None else prev_node.next.val



	# Removes the mapping of the specified value key if this map contains a mapping for the key

	def remove(self, key):

		i = self.find_index(key)

		if self.Hashlist[i] == None:

			return

		prev_node = self.find_node(self.Hashlist[i], key)

		if prev_node.next == None:

			return None

		prev_node.next = prev_node.next.next



	def find_index(self, key):

		return hash(key) % len(self.Hashlist)



	def find_node(self, head, key):

		cur = head

		prev = None

		while cur != None and cur.key != key:

			prev = cur

			cur = cur.next

		return prev