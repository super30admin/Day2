//o(1) time for add and amortized o(1) for pop and peek
//o(n) space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach : push element in one stack, for pop move all elements from s1 to s2, and leep popping, if its empty again, move all elements from s1 to s2 again


class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
         if(empty()) return -1;
         if(s2.isEmpty()){
            move();
        }

       return s2.pop();
    }

    public int peek() {

        if(empty()) return -1;
        if(s2.isEmpty()){
            move();
        }

        return s2.peek();

    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public void move(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
}




//o(n) time for add and o(1) tiem for other functions
//o(n) space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach : to add element recursive;ly go to the  bottom of stack and ad the element
import java.util.Stack;
class MyQueue1 {

  Stack<Integer> s;

    public MyQueue1() {
        s = new Stack<>();
    }

    public void push(int x) {
      if(s.size() == 0){
        s.push(x);
        return;
      }
      int val = s.pop();
      push(x);
      s.push(val);
    }

    public int pop() {
        return empty() ? -1 : s.pop();
    }

    public int peek() {
        return empty() ? -1 : s.peek();
    }

    public boolean empty() {
        return s.size() == 0;
    }
}
