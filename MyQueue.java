import java.util.Stack;

class MyQueue {
    Stack<Integer> stin;
    Stack<Integer> stout;
    public MyQueue() {
        stin=new Stack<>();
        stout=new Stack<>();
    }

    public void push(int x) {
        stin.push(x);
    }

    public int pop() {
        peek();
        return stout.pop();
    }

    public int peek() {
        if(stout.isEmpty()){
            while(!stin.isEmpty()){
                int i=stin.pop();
                stout.push(i);
            }
        }
        return stout.peek();
    }

    public boolean empty() {
        return stin.isEmpty() && stout.isEmpty();
    }
}
