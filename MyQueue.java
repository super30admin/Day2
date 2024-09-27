// Time Complexity :
//  push : O(N)
//  pop: O(N) worst case, ideally O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
// took 2 stacks and moved them one to another during pop if pop stack is empty
class MyQueue {

    Stack<Integer> pushSt;
    Stack<Integer> popSt;
    public MyQueue() {
        pushSt = new Stack<Integer>();
        popSt = new Stack<Integer>();
    }
    
    public void push(int x) {
        pushSt.push(x);
    }
    
    public int pop() {
        if(popSt.isEmpty()){
            while(!pushSt.isEmpty()){
                popSt.push(pushSt.pop());
            }
        }
        return popSt.pop();
    }
    
    public int peek() {
        if(popSt.isEmpty()){
            while(!pushSt.isEmpty()){
                popSt.push(pushSt.pop());
            }
        }
        return popSt.peek();
    }
    
    public boolean empty() {
        return pushSt.isEmpty() && popSt.isEmpty();
    }
}
