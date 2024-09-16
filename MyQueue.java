import java.util.Stack;

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public class MyQueue{
    //Declaring two input and output stacks
    Stack<Integer> in;
    Stack<Integer> out;

    //initializing using Constructor

    public MyQueue(){
        in=new Stack<>();
        out=new Stack<>();
    }
    // push element at the back of queue
    public void push(int x){
        in.push(x);
    }
    //remove element from in front of queue and return that element

    public int pop(){
        peek();
        return out.pop();
    }
    public int peek(){
        //if the out stack is empty we will iterate over in Stack and pop elements from in stack and push it to out stack untill in stack becomes empty
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    public boolean empty()
    {
        return in.isEmpty() && out.isEmpty();
    }




}