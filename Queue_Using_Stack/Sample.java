// Time Complexity : worst case O(n) for peek and pop operation. Else O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use two stacks first and second. For push operation we push current element in first.
 * for pop, we check if second is empty. If yes then we put all elements of first into second. this gives 
 * us the elements in FIFO order in second stack so till second gets empty, we can easily track elements in FIFO pattern
 * this allows us to remove elements in FIFO pattern in O(1) time till second stack gets empty.
 * So for each pop operation we remove element from second.
 * same operation we perform in peek just we dont remove element from stack
 * for empty operation we return true only if both stacks are empty. since it can be the case that we recently put all elements
 * from first into sec so first is empty or we perform enough pop operation to make second empty and we have atleast one element in first due to push 
 * So since either of them can have element in them, we will return true only when both stacks are empty else we return false
*/

class MyQueue {
       Stack<Integer> first;
       Stack<Integer> sec;
    public MyQueue() {
      this.first  = new Stack<Integer>();
      this.sec  = new Stack<Integer>();  
    }
    
    public void push(int x) {
        this.first.push(x);
        
    }
    
    public int pop() {        
        //check if sec is empty
        if(sec.empty()){
          //if yes then put first in sec
          while(first.isEmpty() == false){
               sec.push(first.pop());
           } 
         }
         int ret = sec.pop(); 
         return ret;
    }
    
    public int peek() {
        
        if(sec.empty()){
          while(first.isEmpty() == false){
               sec.push(first.pop());
           }    
        }
        return sec.peek();
    }
    
    public boolean empty() {
        if(first.empty() && sec.empty()) return true;
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