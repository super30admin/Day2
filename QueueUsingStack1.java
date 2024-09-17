import java.util.Stack;

class QueueUsingStack1 {
    private Stack<Integer> s = new Stack();
    private Stack<Integer> t = new Stack();

    public QueueUsingStack1()
    {

    }

    public void push(int x)
    {
        while(!s.isEmpty())t.push(s.pop());
        s.push(x);
        while(!t.isEmpty())s.push(t.pop());
    }

    public int pop()
    {
        return s.pop();
    }

    public int peek()
    {
        return s.peek();
    }

    public boolean empty()
    {
        return s.isEmpty();
    }
}
