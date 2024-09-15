/*
PUSH = O(1)
POP = O(N)
PEEK = O(N)
EMPTY = O(1)
*/
class MyQueue {

    Stack<Integer> stack1 ;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {

        stack1.push(x);

    }

    public int pop() {
       while(!stack1.isEmpty())
       {
           stack2.push(stack1.pop());

       }
        int val = stack2.pop();
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
        return val;
    }

    public int peek() {
        while(!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
        int val = stack2.peek();
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
        return val;

    }

    public boolean empty() {
         if (stack1.isEmpty())
         {
                 return true ;
         }
             else{ return false;}
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