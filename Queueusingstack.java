//Time complexity is O(1)
//Space complexity is O(2N)
class MyQueue {
Stack<Integer> pushing;
Stack<Integer> popping;
    
    public MyQueue() {
        //Creating two stacks one for pushing values and other for popping values
        pushing=new Stack<>();
        popping=new Stack<>();
    }
    
    public void push(int x) {
        //Pushing the elemements into the pushing stack
        pushing.push(x);
    }
    
    public int pop() {
        peek();
        return popping.pop();
    }
    
    public int peek() {
        //Checking if the popping stack is empty and if it is empty transfering all the elements from the pushing stack into the popping stack
        if(popping.isEmpty()){
            while(!pushing.isEmpty()){
                popping.push(pushing.pop());
            }
        }
        return popping.peek();
    }
    
    public boolean empty() {
        //Checking if the stacks are empty
        return pushing.isEmpty() && popping.isEmpty();
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