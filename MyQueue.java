// Time Complexity : push pop isempty is O(1)
// Space Complexity : O(n) where n is size of in/out
// Did this code successfully run on Leetcode : Yes
import java.util.Stack;

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    /*
    Push always to in stack
    @param : int x
    @return:None
     */
    public void push(int x) {
        this.in.push(x);
    }

    /*
    Peek as it copies all of in stack into out if out is empty, if not whatever is on top of out is removed and returned
    @param : None
    @return: top of out
    */
    public int pop() {
        peek();
        return this.out.pop();
    }

    /*
        Peek as it copies all of in stack into out if out is empty, if not whatever is on top of out
        @param : None
        @return: top of out
  */
    public int peek() {
        if(this.out.isEmpty()){
            while(!this.in.isEmpty()){
                this.out.push(this.in.pop());
            }
        }
        return this.out.peek();
    }
    /*
        true if any ele in, in or out
        @param : None
        @return: boolean if any values in, in or out
  */
    public boolean empty() {
        return this.in.isEmpty() && this.out.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}