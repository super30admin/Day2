
import java.util.*;
public class Main
{
    private Stack<Integer> mainStack;
    private Stack<Integer> secondaryStack;
    Main()
    {
        mainStack = new Stack<Integer>();
        secondaryStack = new Stack<Integer>();
    }
	public static void main(String[] args)
	{
	    Main m = new Main();
        m.push(4);
        System.out.println(m.pop());
        m.push(9);
        m.push(7);
        m.push(99);
        System.out.println(m.peek());
        System.out.println(m.empty());
	}
	
	public void push(int val)
	{
	    mainStack.push(val);
	}
	public int pop()
	{
	    if(secondaryStack.isEmpty())
	    {
	        while(!mainStack.isEmpty())
	        {
	            secondaryStack.push(mainStack.pop());
	        }
	    }
	    return secondaryStack.pop();
	}
	public int peek()
	{
	    if(secondaryStack.isEmpty())
	    {
	        while(!mainStack.isEmpty())
	        {
	            secondaryStack.push(mainStack.pop());
	        }
	    }
	    return secondaryStack.peek();
	}
	public boolean empty()
	{
	    return mainStack.isEmpty() && secondaryStack.isEmpty();
	}
}
