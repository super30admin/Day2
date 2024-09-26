// Queue using stacks

import (
    "container/list"
)

type Stack struct{
    data *list.List
}

func NewStack() *Stack {
    return &Stack{
        data: list.New(),
    }
}

func (s *Stack) Len() int {
    return s.data.Len()
}

func (s *Stack) Push(x int) {
    s.data.PushBack(x)
}

func (s *Stack) Pop() *list.Element {
    if s.Len() == 0 {
        return nil
    }
    e := s.data.Back()
    s.data.Remove(e)
    return e
}

func (s *Stack) Peek() *list.Element {
    return s.data.Back()
}

type MyQueue struct {
    pushStack *Stack
    popStack *Stack
}

func Constructor() MyQueue {
    return MyQueue {
        pushStack: NewStack(),
        popStack: NewStack(),
    }
}

func (this *MyQueue) Push(x int)  {
    this.pushStack.Push(x)
}


func (this *MyQueue) Pop() int {
    e := this.Peek()
    this.popStack.Pop()
    return e
}


func (this *MyQueue) Peek() int {
    if this.popStack.Len() == 0 {
        for this.pushStack.Len() != 0 {
            this.popStack.Push(this.pushStack.Pop().Value.(int)) 
        }
    }
    e := this.popStack.Peek()
    if e != nil {
        return e.Value.(int)
    }
    return -1
}


func (this *MyQueue) Empty() bool {
    return this.pushStack.Len() == 0 && this.popStack.Len() == 0
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */