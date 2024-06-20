//used two stack one to push the elements and other stack to pop the elements
//Whlie pushing time complexity is O(1) as element is directly push to stack
//while pop time complexity is O(1) as we only copy to other stack when that stack is empty
//so average case time complexity is O(1)

//Total TC: O(1)

public class MyQueue {
    private Stack<int> mainStack;
    private Stack<int> popStack;
    public MyQueue() {
        mainStack= new Stack<int>();
        popStack= new Stack<int>();
    }
    
    //TC: O(1)
    public void Push(int x) {
        mainStack.Push(x);
    }
    
    //TC: O(1)
    public int Pop() {
        Peek();  
        return  popStack.Pop();      
    }
    
    //TC: O(1)
    public int Peek() {
       if(popStack.Count == 0){
            while(mainStack.Count!=0){
                popStack.Push(mainStack.Pop());
            }
        }
        return popStack.Peek();
    }
    
    //TC: O(1)
    public bool Empty() {
        if(mainStack.Count == 0 && popStack.Count  == 0){
            return true;
        }
        return false;
    }
}