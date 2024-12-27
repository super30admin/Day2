import java.util.Stack;

// Time Complexity : Push,Empty :O(1), Pop, Peek: Amortized O(1)
// Space Complexity : O()
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Implemented queue using two stacks, where elements are transferred to st2 from st1 if st2 is empty

class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();

    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        int val =-1;

        if(st2.empty()){
            while(!st1.empty()){
                st2.push(st1.pop());
            }
        }

        if(!st2.empty()){
            val = st2.pop();
        }
        return val;
    }

    public int peek() {
        int val =-1;

        if(st2.empty()){
            while(!st1.empty()){
                st2.push(st1.pop());
            }
        }

        if(!st2.empty()){
            val = st2.peek();
        }
        return val;
    }

    public boolean empty() {
        if(st1.empty() && st2.empty()){
            return true;
        }
        return false;
    }
}
