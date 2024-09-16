// Time Complexity : O(1) - push and O(1) - best in pop and O(N) in worst - this is also called ammortised approach
// Space Complexity : O(1) - not using any extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue { // going with ammortised approach
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x); // always adding element in the firs stack
    }

    public int pop() { // we will always pop element from the s2 stack
        if(s2.isEmpty()){ // if it is empty, then transfer all the elements from s1 to s2
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop(); // return top element in s2
    }

    public int peek() { // same as pop method
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
