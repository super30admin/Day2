// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        peek();
        return output.pop();
    }

    //Need to do this in peek() and not in pop() as it will remove the element, to have common code usage
    public int peek() {
        if(output.empty()) {
            while(!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return output.empty() && input.empty();
    }
}
