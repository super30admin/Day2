import java.util.ArrayDeque;
import java.util.Deque;

//first in first out
//implement queue using stack
//here we use 2 stacks to implement queue
public class MyQueue{

    private Deque<Integer> stack1 ;
    private Deque<Integer> stack2;

    MyQueue(){
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x){
        stack1.push(x);
    }

    //returns first element from data structure
    public int peek(){
        if(empty()) return -1;
        arrange();
        return stack2.peek();
    }

    public int pop(){
        if(empty()) return -1;
        arrange();
        return stack2.pop();
    }

    public boolean empty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void arrange(){
        while(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(2);
        queue.push(4);
        queue.push(1);

        System.out.println(queue.peek());
        System.out.println(queue.pop());

    }
}