package Queue;

import java.util.Stack;

/*
  push method:
  Time complexity : o(1)
  Space complexity : o(1)
  ---------------------------------------------------
  pop method:
  Amortized Time complexity : o(1)
  worstcase time complexity : o(n)
  Space complexity : o(1)
  ---------------------------------------------------
  peek method:
  Time complexity : o(1)
  Space complexity : o(1)
  ---------------------------------------------------
  empty method:
  Time complexity : o(1)
  Space complexity : o(1)
  ---------------------------------------------------
  Did this code run succesfully in leetcode : yes
  problems faces : no
  create two stacks 1 and 1. for everypush operation put element into stack 1
  for first pop operation , fetch all the lements from stack 1 and insert into stack 2.and retur first element from stack2
  for subsequest pop operations , keep popping element from stack2 and return that element.
  when stack 2 becomes empty, insert all the elements from stack 1 to stack 2
  
*/ 
public class MyQueue {
    

   private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
       
    }

    public int peek() {
        
        if (!out.isEmpty()) {
            return out.peek();
        } else {
            while (!in.isEmpty())
                out.push(in.pop());
        }
        return out.peek();
    }

    public boolean empty() {

        return in.empty() && out.empty();

    }


}
