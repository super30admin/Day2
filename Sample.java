
import java.util.Stack;
// Time Complexity :------------ O(1)-------------
// Space Complexity :-----------O(n)---------------
// Did this code successfully run on Leetcode :YES
/* Any problem you faced while coding this : initially I faced outofbound exception . so, searched for my doubts and found
 where I was going wrong*/


// Your code here along with comments explaining your approach
class MyHashSet {
        boolean[] arr;              //created boolean array
    public MyHashSet() {
        /*created new array object of fixed size. given range is 0-1000000
        but if I use array of 1000000 size i will get outOfBound Exception. beacuse index is starting form 0.
        So, here using (range + 1) i.e. 1000001 size of array */
        arr = new boolean[1000001];     
    }
    
    public void add(int key) {
        /*this function doest not return anything if the key/integer is already
         present it will simply replace if not it will be set as true & assumed as key is 
         added */
        arr[key]= true;
    }
    
    public void remove(int key) {
        /* if the key is not in array it will not do anything if the key is
        in array then it will set false and assume that key is deleted*/
        arr[key] = false;
    }
    
    public boolean contains(int key) {
        /* this function simply return if the array contains given key or not  */
        return arr[key];
    }
}
// ********************************************************************************************************************************
/* implementing queue using two stacks */
class MyQueue {
    Stack<Integer> inStack; //created stacks
    Stack<Integer> outStack;
    int popedElement;
    public MyQueue() {
       this.popedElement=0;     
       this.inStack= new Stack<>();             
        this.outStack= new Stack<>();
    }
    
    public void push(int x) {
        this.inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                this.outStack.push(inStack.pop());
            }
            if(!outStack.isEmpty()){
             popedElement = outStack.pop();
            }
        }else{
            popedElement = outStack.pop();
        }
        return popedElement;
    }
    
    public int peek() {
        int peekElement=0;
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                this.outStack.push(inStack.pop());
            }
            if(!outStack.isEmpty()){
             peekElement = outStack.peek();
            }
        }else{
            peekElement = outStack.peek();
        }
        return peekElement;
    }
    
    
    public boolean empty() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                this.outStack.push(inStack.pop());
            }
            if(!outStack.isEmpty()){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
}


