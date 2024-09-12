//Time complexity is O(N)
//Space complexity is O(N)
//Able to submit in leetcode
class MyQueue {
    Stack<Integer> front = new Stack<>();
    Stack<Integer> end = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        front.push(x);
    }
    
    public int pop() {
        if(!end.isEmpty()){
            return end.pop();
        }
        else{
            int result=-1;
            while(!front.isEmpty()){
                result = front.pop();
                end.push(result);
            }
            end.pop();
            return result;
        }
    }
    
    public int peek() {
        if(!end.isEmpty()){
            return end.peek();
        }
        else{
            int result = -1;
            while(!front.isEmpty()){
                result = front.pop();
                end.push(result);
            }
            return result;
        }
    }
    
    public boolean empty() {
        return front.isEmpty() && end.isEmpty();
    }
}
