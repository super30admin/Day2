package s30Coding;

import java.util.*;

//Time complexity :- 

//	push :- O(1)
//	pop :- O(1) worst case:- O(n);
// 	peek :- O(1) worst case :- O(n);
// 	empty :- O(1);

// Space Complexity :-
//	push :- O(1)
//	pop :- O(1);
//	peek :- O(1);
//	empty :- O(1);
 
//	The code successfully runs on LeetCode

// One problem I face was calling the peek function 2nd time went wrong. 
// But I just had to check it 2nd stack is empty or not, so I got the solution after seeing the test case. 



public class MyQueue {
	
//	Queue Implementation using 2 stacks
	
	private Stack<Integer> s1;
	private Stack<Integer> s2;

    // Initialize data structure here.
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    // Push element x to the back of queue. 
    public void push(int x) {
        s1.push(x);
    }
    
    // Removes the element from in front of queue and returns that element.
    public int pop() {
        if(s2.isEmpty()){
           while(!s1.isEmpty()) {
			s2.push(s1.pop());
		} 
        }
        
		return s2.pop();
    }
    
    // Get the front element.
    public int peek() {
      if (!s2.isEmpty()) {
            return s2.peek();
        } else {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.peek();
    }
    
    // Returns whether the queue is empty.s
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
//	LinkedList approach
	
//	private LinkedList<Integer> list = new LinkedList<>();
	
//	public void push(int x) {
//		list.add(x);
//	}
//	public int pop() {
//		return list.removeFirst();
//	}
//	
//	public int peek() {
//		return list.getFirst();
//	}
//	
//	public boolean empty() {
//		return list.isEmpty();
//	}
	

}
