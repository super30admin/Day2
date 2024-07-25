// Time complexity: O(1)
// Space Complexity: O(1)
import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public QueueUsingStack(){
        in = new Stack<>();
        out = new Stack<>();
    }

    private void push(int val){
        in.push(val);
    }
    private int pop(){
        peek();
        return out.pop();
    }

    private int peek(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    private boolean isEmpty(){
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args){
        QueueUsingStack q = new QueueUsingStack();
        q.push(1);
        q.push(2);
        q.push(3);
        q.pop();
        q.peek();

        System.out.println("peek: " + q.peek());
    }
}
