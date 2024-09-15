/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myqueue;

import java.util.Stack;

/**
 *
 * @author Samartha_Swaroop
 */
public class MyQueue {
Stack<Integer> temp = new Stack<Integer>();
    Stack<Integer> value = new Stack<Integer>();
 
   
    public void push(int x) {
        if(value.isEmpty()){
            value.push(x);
        }else{
            while(!value.isEmpty()){
                temp.push(value.pop());
            }
 
            value.push(x);
 
            while(!temp.isEmpty()){
                value.push(temp.pop());
            }    
        }
    }
 
    
    public void pop() {
        value.pop();
    }
 
    
    public int peek() {
        return value.peek();
    }
 
    
    public boolean empty() {
        return value.isEmpty();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
