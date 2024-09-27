
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
pushing into Queue is straight forward pushing into "in" stack as is
to pop from Queue: pop from "out" stack if not empty (as order is reversed when things moved from in to out stack)
if "out" stack is empty move all elements from "in" stack to "out" stack this reverses order to queue no pop
*/

package main

import "fmt"

type MyStack struct {
	Stack []int
}

func (e *MyStack) StackPush(val int) {
	e.Stack = append(e.Stack, val)
}
func (e *MyStack) StackPop() int {
	if len(e.Stack) > 0 {
		n := len(e.Stack) - 1
		val := e.Stack[n]
		e.Stack = e.Stack[:n]
		return val
	}
	return -1
}
func (e *MyStack) StackTop() int {
	if len(e.Stack) > 0 {
		n := len(e.Stack) - 1
		return e.Stack[n]
	}
	return -1
}
func (e *MyStack) StackIsEmpty() bool {
	return len(e.Stack)<1
}



type MyQueue struct {
	In MyStack
	Out MyStack
}


/** Initialize your data structure here. */
func ConstructorQueue() MyQueue {
	var a []int
	var b []int
	in := MyStack{Stack:a}
	out := MyStack{Stack:b}
	var pa MyQueue
	pa = MyQueue{In:in, Out:out}
	return pa
}


/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int)  {
	this.In.StackPush(x)
}


/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() int {
	if this.Out.StackIsEmpty() {
		for !this.In.StackIsEmpty() {
			this.Out.StackPush(this.In.StackPop())
		}
		return this.Out.StackPop()

	} else {
		return this.Out.StackPop()
	}
	return -1
}


/** Get the front element. */
func (this *MyQueue) Peek() int {
	if this.Out.StackIsEmpty() {
		for !this.In.StackIsEmpty() {
			this.Out.StackPush(this.In.StackPop())
		}
		return this.Out.StackTop()
	} else {
		return this.Out.StackTop()
	}
}


/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
	return this.Out.StackIsEmpty() && this.In.StackIsEmpty()
}

func MainQueueUsingStack() {
	myQueue := ConstructorQueue()
	myQueue.Push(1) // queue is: [1]
	myQueue.Push(2) // queue is: [1, 2] (leftmost is front of the queue)
	fmt.Println(myQueue.Peek()) // return 1
	fmt.Println(myQueue.Pop()) // return 1, queue is [2]
	fmt.Println(myQueue.Empty()) // return false
}