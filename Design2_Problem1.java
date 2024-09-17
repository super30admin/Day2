// Time Complexity : Push : O(1), Pop and Peek : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/*

Created 2 Stacks s1 anbd s2
In push : PUsh elements in s1

In Pop : Pop all elements from s1 and push it into s2
Now pop the top element from s2 and return it // Deleted element from front of the queue
Push back all elements from s2 to s1


In peek :  Pop all elements from s1 and push it into s2
Now peek the top element from s2 and return it // element at front of the queue
Push back all elements from s2 to s1

*/
import java.util.Stack;

class Mys2 {
    Stack<Integer> s2,s1;
    public Mys2() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    public void push(int x) {
        s1.push(x);  
    }
    public int pop() {
        while(! s1.isEmpty()){
            s2.push(s1.pop());
        }
        int element = s2.pop(); //Top-most element deleted
        
        while(! s2.isEmpty() ){
            s1.push(s2.pop());
        }
        return element;
    }
    
    public int peek() {
        while(! s1.isEmpty()){
            s2.push(s1.pop());
        }
        int top = s2.peek(); //Top-most element selected
        
        while(! s2.isEmpty() ){
            s1.push(s2.pop());
        }    
        return top;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

public class Design2_Problem1 {
    public static void main(String[] args){
        Mys2 s2 = new Mys2();
        s2.push(1);  s2.push(2); 
    
        System.out.println(("s2.peek() : " + s2.peek())); // FRONY ELEMENT

        System.out.println("s2.empty() : " + s2.empty() );    
    }


}
