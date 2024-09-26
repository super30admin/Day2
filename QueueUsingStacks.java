// Time complexity: 
// push - O(1)
// pop and peek - O(n) 
// Space Complexity:Two stacks would consume O(n) space complexity.


class QueueUsingStacks {
    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public QueueUsingStacks() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();

    }

    public void push(int x) {
        inSt.push(x);
    }

    public int pop() {
        if(outSt.empty()){
            while(!inSt.empty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.pop();

    }

    public int peek() {
        if(outSt.empty()){
            while(!inSt.empty()){
                outSt.push(inSt.pop());
            }
    }
        return outSt.peek();

    }

    public boolean empty() {
        return inSt.empty() && outSt.empty();

    }
}