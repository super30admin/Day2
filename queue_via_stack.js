empty = function(stack) {
  return stack.length < 1
}

top = function(stack) {
  return stack[stack.length-1]
}

MyQueue = function() {
  return Object.assign(
    Object.create(MyQueue.prototype),
    {
      pushStack: [],
      popPeekStack: [],
    }
  )
}

MyQueue.prototype.empty = function() {
  return empty(this.pushStack) && empty(this.popPeekStack)
}
// qvse = MyQueue()/*?*/
// qvse.empty()/*?*/

MyQueue.prototype.push = function(x) {
  this.pushStack.push(x)
}
// qvsp = MyQueue()
// qvsp.push(3)
// qvsp.push(9)
// qvsp.push(2)

MyQueue.prototype.peek = function() {
  if (empty(this.popPeekStack) && empty(this.pushStack))
    return null

  if (empty(this.popPeekStack) && !empty(this.pushStack)) {
    while(!empty(this.pushStack))
      this.popPeekStack.push(this.pushStack.pop())
    return top(this.popPeekStack)
  }

  // if (!empty(this.popPeekStack/*?*/))
  return top(this.popPeekStack)

  // return -1
}
// qvspEmpty = MyQueue();
// qvspEmpty.peek() == null /*?*/

qvsp2 = MyQueue()
qvsp2.push(3)
qvsp2.push(4)
qvsp2.push(5)
qvsp2.peek()/*?*/

MyQueue.prototype.pop = function() {
  if (!empty(this.popPeekStack))
    return this.popPeekStack.pop()

  if (empty(this.pushStack) && empty(this.popPeekStack))
    return null
}
qvsp2.pop()/*?*/
qvsp2.peek()/*?*/
// qvsp.pop()/*?*/
// qvsp.peek() == 9/*?*/
//
// qvspp = MyQueue()
// qvspp.pop() == null/*?*/
//
// qvs = MyQueue()/*?*/
