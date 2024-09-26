// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// We used two stack to store the values, once any pop or peek operation is trigered, all the values from one stack is transfered to other stack and then pop or peek from that stack, as it will be easy till the second stack have some values.

// Your code here along with comments explaining your approach


class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stPush;
    Stack<Integer> stPop;
    public MyQueue() {
        stPush =  new Stack<>();
        stPop = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stPush.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stPop.isEmpty()){
            while(!stPush.isEmpty()){
                stPop.push(stPush.pop());
            }
        }
        return stPop.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stPop.isEmpty()){
            while(!stPush.isEmpty()){
                stPop.push(stPush.pop());
            }
        }
        return stPop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if( stPop.isEmpty() && stPush.isEmpty()){
            return true;
        }else{
            return false;
        }
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