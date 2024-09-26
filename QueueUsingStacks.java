//Time Complexity : push, pop, peek empty- O(1) constant time
//Space Complexity : O(n+n) i.e. O(n), n is size of stack in and out stacks
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : no

//Your code here along with comments explaining your approach

/*I am creating 2 stacks OF SAME size, namely in and out. In stack will have initial push operations till we encounter peek or pop. Once we encounter pop/peek operation, 
 * we will transfer all the elements into stack in a manner that the bottommost element in IN stack will appear on top in OUT stack. We hayve written various functions to imitate queue 
*/



import java.util.*;

public class QueueUsingStacks {

	    //declaration of 2 stacks to be used
	    static Stack<Integer> in;
	    static Stack<Integer> out;
	    
	    public static void QueueUsingStacks() {   //initialization of 2 stacks
	        in= new Stack<>();
	        out= new Stack<>();
	    }
	    
	    public static void push(int x) { //function for pushing the elements into IN stack
	        in.push(x);
	    }
	    
	    public static int pop() {    //function for popping the elements from IN stack and pushing same element into OUT stack till the IN stack becomes empty. Then we will perform final pop operation on OUT stack
	        if(out.isEmpty()){while(!in.isEmpty()){
	            out.push(in.pop());
	        }
	        }return out.pop();
	    }
	    
	    public static void peek() {  //function for peeking the element from top of out stack. elements are again popped from IN stack and pushed same element into OUT stack till the IN stack becomes empty. 
	        if(out.isEmpty()){while(!in.isEmpty()){
	            out.push(in.pop());
	        }
	        }
	        System.out.println(out.peek());
	    }
	    
	    public static boolean empty() { //checks whether any or bboth stacks are empty or not.. Even if 1 stack is empty will return Queue as empty
	        if(out.isEmpty() && in.isEmpty())
	        {
	            return true;
	        }
	        else{return false;}
	    }

	public static void main(String[] args) {
		QueueUsingStacks();
		Scanner inpObj = new Scanner(System.in); 
	    do
    	{
	    	System.out.println("Enter the operation(push,pop,peek,IsEmpty) and Q/q to exit \n");
	    	String text = inpObj.nextLine(); 
	    	if(text.equals("Q") || text.equals("q"))
	    	{
	    		break;
	    	}
	    	if(text.equals("push"))
	    	{
	    		System.out.println("Please enter the integer element you want to push into stack");
	    		Scanner sc= new Scanner(System.in); 
	    		int num=sc.nextInt();
	    		push(num);
	    	}
	    	if(text.equals("pop"))
	    	{
	    		pop();
	    	}
	    	if(text.equals("peek"))
	    	{
	    		peek();
	    	}
	    	if(text.equals("isEmpty"))
	    	{
	    		empty();
	    	}
	    	
    	}	while(true);

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
