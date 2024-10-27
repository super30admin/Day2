/*
 Time Complexity : For user oriented functions, push, pop, peep, empty time complexity is O(1). For pop, only once in a blue moon we will have
                time complexity as O(n) because we have to move all elements to out stack from in stack once out stack is empty. But since it
                is so rare, the average time complexity will be considered which is O(1) for selecting data structures.

 Space Complexity : The space complexity of queue implementation with two stacks remains O(n) because the storage needed grows linearly with
                    the number of elements in the queue.

 Did this code successfully run on Leetcode : Yes

Property of Queue: FIFO
1) Two stacks will be used to implement queue , as asked in the problem statement
9,5,6,7,2

 |   2   |          |       |
 |   7   |          |       |
 |   6   |          |       |
 |   5   |          |       |
 |   9   |          |       |

  IN STACK           OUT STACK

2) POP,8,POP,10

Now, we need to transfer all elements in Out stack before Pop to get the First element

 |      |          |   9   |
 |      |          |   5   |
 |      |          |   6   |
 |      |          |   7   |
 |      |          |   2   |

 POP

 |      |          |       |
 |      |          |   5   |
 |      |          |   6   |
 |      |          |   7   |
 |      |          |   2   |

 Insert 8
 |      |          |       |
 |      |          |   5   |
 |      |          |   6   |
 |      |          |   7   |
 |   8  |          |   2   |

  POP

 |      |          |       |
 |      |          |       |
 |      |          |   6   |
 |      |          |   7   |
 |   8  |          |   2   |

 Insert 10
 |      |          |       |
 |      |          |       |
 |      |          |   6   |
 |  10  |          |   7   |
 |   8  |          |   2   |

 3) POP, POP, POP
 |      |          |       |
 |      |          |       |
 |      |          |       |
 |  10  |          |       |
 |  8   |          |       |

4) When Out array is empty transfer elements from In to Out
 |      |          |       |
 |      |          |       |
 |      |          |       |
 |      |          |   8   |
 |      |          |   10  |

 5) Insert 11
 |      |          |       |
 |      |          |       |
 |      |          |       |
 |      |          |   8   |
 |  11  |          |   10  |

 */

import java.util.Stack;

class QueueUsingStacks {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public QueueUsingStacks() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {

        /*
        Edge case we don't need, but still writing it => we can't pop on an empty stack but in problem statement
        it is mentioned All the calls to pop and peek are valid.
        */
        if(empty())
            return -1;

        peek();

        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){

            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.peek();
    }

    public boolean empty() {
        //If both the stacks are empty then queue is empty
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */