// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyQueue{

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        peek();
        return output.pop();
    }

    public int pop(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }

        if(!output.isEmpty()){
            return output.pop();
        }

        else{
            return -1;
        }
    }

    public int peek(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }

        if(!output.isEmpty()){
            return output.pop();
        }

        else{
            return -1;
        }
        
    }

    public boolean empty(){
        return input.isEmpty() && output.isEmpty();
    }
}