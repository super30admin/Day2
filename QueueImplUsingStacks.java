import java.util.Stack;

/**
 * Time complexity of all push is O(1)
 * Time complexity of all pop is O(1) on average and o(n) in worst case
 * Time complexity of all peek is O(1) on average and o(n) in worst case
 * pop and peek operations are amortized
 * Time complexity of all isEmpty is O(1)
 * Space complexity is O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
public class QueueImplUsingStacks {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public QueueImplUsingStacks(){
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek();
        if(!outStack.isEmpty())
            return outStack.pop();
        else
            return -1;
    }

    public int peek() {
        if(outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        if(!outStack.isEmpty())
            return outStack.peek();
        else return -1;
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueImplUsingStacks obj = new QueueImplUsingStacks();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        int param_5 = obj.pop();
        int param_6 = obj.peek();
    }
}
