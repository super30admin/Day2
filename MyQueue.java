// Time Complexity : O(N)  (Amortized : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO
class MyQueue {
    Stack<Integer> a;
    Stack<Integer> b;  
public MyQueue() {
     a=new Stack<Integer>();
     b=new Stack<Integer>();              
}

public void push(int x) {
        a.push(x);
}

public int pop() {
     if(a.isEmpty()==true && b.isEmpty()==true) return -1;
    if(a.isEmpty()==true && b.isEmpty()==false) return b.pop();
   if(  b.isEmpty()==true)
    while(a.isEmpty()==false){
        b.push(a.pop());
    }
   return b.pop();
}

public int peek() {
    if(a.isEmpty()==true && b.isEmpty()==true) return -1;
     if(a.isEmpty()==true && b.isEmpty()==false) return b.peek();
     if(  b.isEmpty()==true)
    while(a.isEmpty()==false){
        b.push(a.pop());
    }
   return b.peek();
}

public boolean empty() {
    if(a.isEmpty()==true && b.isEmpty()==true) return true;
    return false;
}
}

/**
* Your MyQueue object will be instantiated and called as such:
* MyQueue obj = new MyQueue();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.peek();
* boolean param_4 = obj.empty();
*/