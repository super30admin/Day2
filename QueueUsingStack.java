import java.util.Stack;
class MyQueue{ 

// first attempt
//time taken for logic and code: 40 minutes
// notes : It was after initial attempt that I realized that one stack will be queue like and the other will be stack like
    Stack<Integer> stack;
    Stack<Integer> queueStack;

    public MyQueue() {
             stack = new Stack<>();
       queueStack = new Stack<>(); 
    }
    
    //time complexity: O(n)
    public void push(int x) {
    if (stack.isEmpty()){
        while (!queueStack.isEmpty()){
            stack.push(queueStack.pop());
        }
    }
    stack.push(x);
    }
    
    //time complexity: O(n)
    public int pop() {
        if (!queueStack.isEmpty()){
            return queueStack.pop();
        } else {
            while (!stack.isEmpty()){
                queueStack.push(stack.pop());
            }
            return queueStack.pop();
        }
    }
    
    //time complexity: O(n)
    public int peek() {
        if (!queueStack.isEmpty()){
            return queueStack.peek();
        } else {
            while (!stack.isEmpty()){
                queueStack.push(stack.pop());
            }
            return queueStack.peek();
        }
    }
    
    //time complexity: O(1)
    public boolean empty() {
        return (stack.isEmpty() && queueStack.isEmpty());
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // returns 1
        System.out.println(queue.pop()); // returns 1
        System.out.println(queue.empty()); // returns false
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