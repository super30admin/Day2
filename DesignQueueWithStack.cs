public class MyQueue {
    private Stack<int> mainStack;
    private Stack<int> popStack;
    
    public MyQueue() {
        mainStack= new Stack<int>();
        popStack= new Stack<int>();
    }
    
    public void Push(int x) {
        mainStack.Push(x);
    }
    
    public int Pop() {
        Peek();  
        return  popStack.Pop();      
    }
    
    public int Peek() {
       if(popStack.Count == 0){
            while(mainStack.Count!=0){
                popStack.Push(mainStack.Pop());
            }
        }
        return popStack.Peek();
    }
    
    public bool Empty() {
        if(mainStack.Count == 0 && popStack.Count  == 0){
            return true;
        }
        return false;
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