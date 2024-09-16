# Time Complexity : o(1) All Operations
# Space Complexity : o(1) No extra space used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashMap:
	class Node(object):
		def __init__(self, key, val):
			self.key = key
			self.val = val
			self.next = None
	def __init__(self):
		self.Hashlist = [None] * 10000
	def put(self, key, value):
		i = self.find_index(key)
		if self.Hashlist[i] == None:
			self.Hashlist[i] = self.Node(-1, -1)
		prev_node = self.find_node(self.Hashlist[i], key)
		if prev_node.next == None:
			prev_node.next = self.Node(key, value)
		else:
			prev_node.next.val = value
	def get(self, key):
		i = self.find_index(key)
		if self.Hashlist[i] == None:
			return -1
		prev_node = self.find_node(self.Hashlist[i], key)
		return -1 if prev_node.next == None else prev_node.next.val
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