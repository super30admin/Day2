#Time complexity - O(1) for push, O(1) on average for pop, O(n) worst case for pop, O(1) avg for peek, O(n) worst for peek, O(1) for empty
#space complexity - O(n) 

class MyQueue:

	def __init__(self):
		"""
		Initialize your data structure here.
		"""
		self.stack_1 = []
		self.stack_2 = []
		

	def push(self, x: int) -> None:
		"""
		Push element x to the back of queue.
		"""
		self.stack_1.append(x)
		

	def pop(self) -> int:
		"""
		Removes the element from in front of queue and returns that element.
		"""
		if self.stack_2:
			return self.stack_2.pop()
		else:
			while self.stack_1:
				self.stack_2.append(self.stack_1.pop())
			return self.stack_2.pop()
			

	def peek(self) -> int:
		"""
		Get the front element.
		"""
		if self.stack_2:
			return self.stack_2[-1]
		else:
			while self.stack_1:
				self.stack_2.append(self.stack_1.pop())
			return self.stack_2[-1]
		

	def empty(self) -> bool:
		"""
		Returns whether the queue is empty.
		"""
		if self.stack_1 or self.stack_2:
			return False
		else:
			return True
		


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()