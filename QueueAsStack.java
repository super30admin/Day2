import java.util.Stack;

// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach



public class QueueAsStack{

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    // Initializing two stacks in the constructor
    public QueueAsStack(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    // push function 
    public void push(int x){
        //Here I am taking all the elements from stack1 if present and pushing in stack2 till stack 1 is empty
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        //Here i am pushing the new element in the now empty stack1 or if it is the 1st element that we are putting in the queue
        stack1.push(x);
        //As now I have the newest element in the Bottom so as to follow Queues FIFO feature, I am again poping all the elements from stack2 and push in stack1 so
        //as to get the 1st element put in the queue at the top of the stack
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }

    // pop function
    public int pop(){
        //checking if queue is empty returning -1
        if(stack1.empty()){
            System.out.println("queue is empty");
            return -1;
        }
        //Else returning the top element as maintained in the push function
        else{
            int x = stack1.peek();
            stack1.pop();
            return x;
        }
    }

    // Checking if the queue is empty using basic stack empty() method
    public boolean isEmpty(){
        if(stack1.empty()){
            return true;
        }
        else{
            return false;
        }
    }

    // returning the 1st element placed our queue DS using basic stack peek() method achieved due to our above push() method
    public int peek(){
        return stack1.peek();
    }
}