/*Discussed in class*/
class MyQueue() {

    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int peek() {
        transferInToOutIfRequired();
        return out.peek();
    }

    public int pop() {
        transferInToOutIfRequired();
        return out.pop();

    }

    private void transferInToOutIfRequired() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

    }

    public boolean isEmpty()
    {
        return in.isEmpty() && out.isEmpty();
    }
}