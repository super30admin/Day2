# Did this code successfully run on Leetcode : YES

# Approach
# All elements of queue are pushed into stack1
# when first element of queue is needed (both peek and pop)
# all elements from stack1 are popped and simultaneously pushed into stack2
# hence top of stack2 will actually be first element in queue



class MyQueue:

	def __init__(self):
		"""
		Initialize your data structure here.
		SC: O(N)
		"""
		self.stack1 = []
		self.stack2 = []
		

	def push(self, x: int) -> None:
		"""
		Push element x to the back of queue.
		TC: O(1)
		---------
		arguments:
		x: int, value to put in queue
		---------
		"""
		self.stack1.append(x)
		

	def pop(self) -> int:
		"""
		Removes the element from in front of queue and returns that element.
		TC: O(n)
		---------
		returns:
		front_elem: int, element in first position in queue
		"""
		front_elem = self.peek(True)
		return front_elem
		

	def peek(self, flag=False) -> int:
		"""
		Get the front element.
		TC: O(n)
		since pop n elements from stack1 and push same n elements into stack2
		-----------
		arguments:
		flag: bool, default False
		if False, peek performs peek operation
		if True, peek performs pop operation
		---------
		returns:
		front_elem: int, element at first position in queue
		if flag is False, first elem is just viewed (peeked) and returned
		if flag is True, first elem is popped and returned
		"""
		while self.stack1:
			self.stack2.append(self.stack1.pop())
		if not flag:
			front_elem = self.stack2[-1]
		else:
			front_elem = self.stack2.pop()
		while self.stack2:
			self.stack1.append(self.stack2.pop())
		return front_elem
		

	def empty(self) -> bool:
		"""
		Returns whether the queue is empty.
		---------
		returns:
		empty: bool, True if queue is empty else False
		TC: O(1)
		SC: O(1)
		"""
		return (len(self.stack1) == 0)
		

# Slightly optimized approach based on discussion in class
# No need to transfer all elements from stack2 to stack1 everytime
# let pop() operation 

class MyQueue:

	def __init__(self):
		"""
		Initialize your data structure here.
		SC: O(N)
		"""
		self.stack1 = []
		self.stack2 = []
		

	def push(self, x: int) -> None:
		"""
		Push element x to the back of queue.
		TC: O(1)
		---------
		arguments:
		x: int, value to put in queue
		---------
		"""
		self.stack1.append(x)
		

	def pop(self) -> int:
		"""
		Removes the element from in front of queue and returns that element.
		TC: O(1) in best and average case and O(n) in worst case
		---------
		returns:
		front_elem: int, element in first position in queue
		"""
		if self.stack2:
			return self.stack2.pop()
		self.peek()
		front_elem = self.stack2.pop()
		return front_elem
		

	def peek(self) -> int:
		"""
		Get the front element.
		TC: O(1) in best and average case and O(n) in worst case
		since pop n elements from stack1 and push same n elements into stack2
		---------
		returns:
		front_elem: int, element at first position in queue
		"""
		if self.stack2:
			return self.stack2[-1]
		while self.stack1:
			self.stack2.append(self.stack1.pop())
		return self.stack2[-1]
		

	def empty(self) -> bool:
		"""
		Returns whether the queue is empty.
		---------
		returns:
		empty: bool, True if queue is empty else False
		TC: O(1)
		SC: O(1)
		"""
		return (len(self.stack1) == 0 and len(self.stack2) == 0)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()