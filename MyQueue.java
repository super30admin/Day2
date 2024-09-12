
import java.util.Stack;
public class MyQueue
{
    Stack<Integer> in, out;

    public MyQueue()
    {
        in = new Stack<>();
        out = new Stack<>();
    }

    public  void push(int x)
    {
        in.push(x);
    }

    //Helper function to transfer in stack data to outstack!
    private void transferData(Stack<Integer> in, Stack<Integer> out)
    {
        int temp;
        while (!in.isEmpty())
        {
            temp = in.pop();
            out.push(temp);
        }
    }

    public int pop()
    {
        if(out.isEmpty())
        {
            transferData(in, out);
        }
        return out.pop();
    }

    public int peek()
    {
        if(out.isEmpty())
        {
            transferData(in,out);
        }
        return  out.peek();
    }

    public boolean empty()
    {
        return in.isEmpty() && out.isEmpty();
    }

}

class  Main
{
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        if(q.empty())
        {
            System.out.println("Q is empty!");
        }
        else
        {
            System.out.println("Q is not Empty!");
        }
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        System.out.println("poped Value"+q.pop());
        System.out.println("poped Value"+q.pop());

        q.push(5);
        q.push(6);
        System.out.println("peeked Value"+q.peek());
        System.out.println("poped Value"+q.pop());
    }
}



/*
* Time Complexity : O(1) for every operation
* Space : O(N)
* Approach: Every time push request comes, we push it to the "in" stack.
* once we we come across pop request, transfer alll the data of "in" stack to "out" stack until "in" stack gets empty!!
* and then we will pop the data from the out stack!
* Now we don't need to transfer data to out stack until we figured that :"out" stack is empty!
* */