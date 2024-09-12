//TC: for avg pop = O(1), push O(1), sc: O(N) at max total elements in both  stack will never exceed N. 

public class MyQueue {

	Stack<int> In, Out;
	
    public MyQueue() {
		In = new Stack<int>();
		Out = new Stack<int>();
    }
    
    public void Push(int x) {
        In.Push(x);
    }
    
    public int Pop() {
        if(Empty()) return -1;
		
		Peek();
		
		return Out.Pop();
    }
    
    public int Peek() {
        if(Empty()) return -1;
		
		if(Out.Count != 0) 
			return Out.Peek();
		
		while( In.Count !=0)
		{
			Out.Push(In.Pop());
		}
		return Out.Peek();
    }
    
    public bool Empty() {
        return (In.Count ==0 && Out.Count ==0);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * int param_3 = obj.Peek();
 * bool param_4 = obj.Empty();
 */