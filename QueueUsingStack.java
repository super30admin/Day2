class Stack { 
    static final int MAX = 1000; 
    int top; 
    int a[] = new int[MAX]; // Maximum size of Stack 
  
    boolean isEmpty() 
    { 
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    } 

    Stack() 
    { 
        //Initialize your constructor 
        top = -1;
    } 
  
    boolean push(int x) 
    { 
        //Check for stack Overflow
        if (top == MAX-1) {
            return false;
        }
        top = top + 1;
        a[top] = x;
        return true;
    } 
  
    int pop() 
    { 
        if (isEmpty()) {
            return -1;
        } else {
            int poppedElement = a[top];
            top = top - 1;
            return poppedElement;
        }
    } 
  
    int peek() 
    { 
        if(top > -1 && top < MAX) {
            return a[top];
        } else {
            return -1;
        }
        
    } 
}

public class QueueUsingStack {

    Stack s1, s2;

    public QueueUsingStack() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {

        if (s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
        
    }
    
    public int peek() {

        if (s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
        
    }
    
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        return false;
    }
}