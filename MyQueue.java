import java.util.Stack;

public class MyQueue {

        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);                //push into inStack
        }

        public int pop() {
            move();                         //transfer the element to outStack to get the first number
            return outStack.pop();          //pop the first number inserted
        }

        public int peek() {
            move();
            return outStack.peek();
        }

    // Move elements from inStack to outStack if outStack is empty.
        private void move(){
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}

//TimeComplexity:
//push -> O(1)
//pop() -> Amortized O(1)
//peek() -> Amortized O(1)
//empty() -> O(1)
// Space Complexity -> O(n)