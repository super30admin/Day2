import java.util.Stack;

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
     
    public MyQueue() {

        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
       if(s2.isEmpty()){
           transfer(s1,s2);
       } 
       return s2.pop();

    }

    public int peek() {
        if(s2.isEmpty()){
            transfer(s1,s2);
        }
        return s2.peek();

    }

    public boolean empty() {

        return s1.isEmpty() && s2.isEmpty();
    }

    private void transfer(Stack<Integer> s1, Stack<Integer> s2){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }



/*
    Stack<Integer> s1;
    Stack<Integer> s2;
     
    public MyQueue() {

        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {

        if(s1.isEmpty()){
            s1.push(x);
        }
        else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(x);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        
    }
    
    public int pop() {

   
        return s1.pop();

        //return s2.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        if(!s1.isEmpty()){
            return false;
        }
        return true;
    }
*/

    public static void main(String args[]) {
        MyQueue m = new MyQueue();
        m.push(1);
        m.push(2);
        System.out.println(m.peek());
        System.out.println(m.pop());
        System.out.println(m.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */