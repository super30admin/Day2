// Time Complexity :
// push : O(1)
// pop  : Amortised O(1)
// peek : O(1)
// Space Complexity : O(N) - two stacks holding N queue elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Push : all push operations happen to stack s1
Pop  : When a pop operation occurs,if s2 is empty then we push all elements from stack s1 to s2
and continue popping from s2 till it is empty, while push operations still happen on s1.
Peek : top element of s2 if it isnt empty else first elements entered in s1
 */
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;

    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
        front=-1;
    }

    public void push(int x) {
        if(s1.isEmpty()){
            front=x;
        }
        s1.push(x);
    }

    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        return !s2.isEmpty()?s2.peek(): front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
