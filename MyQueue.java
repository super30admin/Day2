// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> pushS = new Stack();
    Stack<Integer> popS = new Stack();

    public MyQueue() {

    }

    public void push(int x) {
        pushS.push(x);
    }

    //if pop stack is not empty return pop if not push element from push stack to pop then return
    public int pop() {
        if(popS.isEmpty()){
            while(!pushS.isEmpty()){
                popS.push(pushS.pop());
            }
            return popS.pop();
        }else{
            return popS.pop();
        }
    }
    //if pop stack is not empty return pop if not push element from push stack to pop then return
    public int peek() {
        if(popS.isEmpty()){
            while(!pushS.isEmpty()){
                popS.push(pushS.pop());
            }
        }
        return popS.peek();
    }

    public boolean empty() {
        return pushS.isEmpty() && popS.isEmpty();
    }
}