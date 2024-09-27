// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :No


package com.s30.day2;

import java.util.Stack;

public class QueueImpl {
	Stack<Integer> st1 =new Stack<>();
	Stack<Integer> st2 =new Stack<>();
	
	public QueueImpl() {
	}
	
	//Pushing all elements to the In stack
	public void push(int x){
		st1.push(x);
	}
	//Popping elements from In stack and pushing to Out stack.
	//Popping elements from Out stack 
	public int pop(){
		if (st2.isEmpty()){
		while (st1.isEmpty()!=true){
		st2.push(st1.pop());
		}
		}
		return st2.pop();	
	}
	
	//Popping elements from In stack and pushing to Out stack.
	//Peeking elements from Out stack 
	public int peek(){
		if (st2.isEmpty()){
			while (st1.isEmpty()!=true){
			st2.push(st1.pop());
			}
			}
			return st2.peek();	
		}
	//If bothe the stacks are empty	
	public boolean empty(){
		if (st1.isEmpty()&& st2.isEmpty()){
			return true;
		}
		    return false;
			
		}
}
