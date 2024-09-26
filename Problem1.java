class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    public MyQueue() {
        //Do Nothing
    }
    
    /** Push element x to the back of queue. */
    //Time Complexity : O(1)
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    //Time Complexity : Amortized O(1)
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    //Time Complexity : Amortized O(1)
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    //Time Complexity : O(1)
    public boolean empty() {
        return s2.isEmpty() && s1.isEmpty();
    }
}

class Main{
    public static void main(String[] args){
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);  
        int peekVal = queue.peek();  // returns 1
        System.out.println("Peek Value of the queue:" + peekVal);
        int popVal = queue.pop();   // returns 1
        System.out.println("Pooped Value of the queue:" + popVal);
        boolean isEmpty = queue.empty(); // returns false
    }
}