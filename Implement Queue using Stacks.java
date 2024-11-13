//using 2 stacks instack will work for pushing th ele, out stack will work for popping the elements


class MyQueue {
    Stack<Integer> inSt;
     Stack<Integer> outSt;
    public MyQueue() {
 
     this.inSt = new Stack<>();
     this.outSt = new Stack<>();

    }
    
    public void push(int x) {//tc-O(1)
         inSt.push(x);
    }
    
    public int pop() {//avg case O(1), only few cases it have to insert element first 
    //then pop in that case it will be O(n), 
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.pop();
    }
    
    
    public int peek() {//avg case O(1), only few cases it have to insert element first 
    //then peep in that case it will be O(n)
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();  
    }
    
    public boolean empty() {//isEmpty will not take any extra time, under the hood
        return inSt.isEmpty() && outSt.isEmpty();
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