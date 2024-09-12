//Overall Time Complexity: O(1) - Amortized
//Overall Space Complexity: O(N) - Auxillary memory to store elements
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    //Time Complexity: O(1)
    public void push(int x) {
        in.push(x);
    }

    //Time Complexity: O(1) - Amortized
    public int pop() {
        if(out.isEmpty()){
            shift();
        }
        if(out.isEmpty()) return -1;
        else return out.pop();
    }

    //Time Complexity: O(1) - Amortized
    public int peek() {
        if(out.isEmpty()){
            shift();
        }
        return out.peek();
    }

    //Time Complexity: O(1)
    public boolean empty() {
        if(out.isEmpty() && in.isEmpty()) return true;
        else return false;
    }

    //Time Complexity: O(N) - Expensive but happens only some times
    private void shift(){
        while(!in.isEmpty()){
            out.push(in.pop());
        }
        return;
    }
}
