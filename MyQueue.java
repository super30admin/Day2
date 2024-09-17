class MyQueue {

    int front;

    Stack s1, s2 ;

    public MyQueue() {

        s1 = new Stack();
        s2 = new Stack();
    }

    public void push(int x) {

        if (s1.isEmpty())
        {
            front = x;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int pop() {

        if(!empty()) {
            return s1.pop();
        }

        return -1;
    }

    public int peek() {
       return front;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}




// Time Complexity : O(n) for push , O(1) for pop
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no. it was solved in class

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
