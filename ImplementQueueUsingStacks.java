import java.util.Stack;
/*
Time Complexity: O(1) for push and empty method, O(n) for both peek() and pop() methods or O(1) amortized

Space Complexity: O(n) as we use stack

Did this code successfully run on Leetcode : Yes

Your code here along with comments explaining your approach,
1. I am using two stacks one is to push all the elements calling it in stack
2. Other one is to pop out the elements which is queue calling it as out
3. Everytime a new element comes I am pushing that to "in" stack,
4. While popping out, I am transferring elements from "in" stack to "out" stack and then popping it from the "out" stack
same operation I am using for peek element
5. If both the "in" or "out" stacks are empty then we can say queue is empty, we don't have any elements to transfer from
"in" stack to "out" stack.

 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public ImplementQueueUsingStacks(){
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x){
        in.push(x);
    }

    public void transferInToOut(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }

    public int pop(){
        transferInToOut();
        return out.pop();
    }

    public int peek(){
        transferInToOut();
        return out.peek();
    }

    public boolean empty(){
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args){
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);

        System.out.println("Pop operation: "+queue.pop());
        System.out.println("Pop operation: "+queue.pop());
        System.out.println("Pop operation: "+queue.pop());
        System.out.println("Pop operation: "+queue.pop());

        System.out.println(queue.peek());

        System.out.println("Is Queue empty?: "+queue.empty());

    }

}
