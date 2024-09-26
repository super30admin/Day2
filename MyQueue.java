// Time Complexity : push() => O(1); pop() => avg O(1) - worst case O(N); peek() => avg O(1) - worst case O(N); empty() => O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        this.in.push(x);
    }
    
    public int pop() {
        if(this.out.isEmpty()){
            while(!this.in.isEmpty()){
                this.out.push(this.in.pop());
            }
        }
        return this.out.pop();
    }
    
    public int peek() {
        if(this.out.isEmpty()){
            while(!this.in.isEmpty()){
                this.out.push(this.in.pop());
            }
        }
        return this.out.peek();
    }
    
    public boolean empty() {
        return this.in.isEmpty() && this.out.isEmpty();
    }
}