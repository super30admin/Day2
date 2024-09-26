// Time Complexity : push =O(1) pop=(n) peek=O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Queue{


    Stack<Integer> queue1;
    Stack<Integer> queue2;
    int top;
    public Queue(){
    top = -1;
    queue  = new Stack<>();
    }

    // Add the element on the back of queue1
    public void push(int value){
    if(isEmpty()){
        top = value;
    }
        queue.push(value);
    }

    // Remove the element from the front of Queue
    public int pop(){
        if(isEmpty){
            return null;
        }
        while(!queue1.isEmpty()){
            queue2.push(queue1.pop());
        }
        int result = queue.pop();
        while(!queue2.isEmpty()){
        if(isEmpty()){
            top = queue2.peek();
        }
            queue1.push(queue2.pop());
        }
        return result;

    }

    //Get tje front element
    public int peek(){
        return top;
    }

    //check if the queue1 is empty
    public boolean isEmpty(){
    if(queue1.size()<1){
        return true;
    }
    return false;
    }

}