// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyQueue {
Stack<Integer> stack1 = new Stack<>();
Stack<Integer> stack2 = new Stack<>();
    public MyQueue() {

    }
    public void move(){
        while (!stack1.isEmpty()){
      int y = stack1.pop();
        stack2.push(y);
        move();}
    }
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if (stack2.isEmpty()){move();}
        return stack2.pop();
    }
    
    public int peek() {
        if (stack2.isEmpty()){move();}
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
Problem 2 
class MyHashMap {
int arr[] = new int[99999];
    public MyHashMap() {
        
    }
    public int hash(int key) {
        int hashfn=key%99999;
        return hashfn;
    }
    public void put(int key, int value) {
        int i = hash(key);
        if (value == 0){
            arr[i] = -2;
        }
       else{ arr[i] = value;}
    }
    
    public int get(int key) {
        int i = hash(key);
        if (arr[i] != 0 || arr[i]==-1){
            if (arr[i] == -2){
            return 0;
        }
       else{ 
            return arr[i];}
        }else{
            return -1;
        }
    }
    
    public void remove(int key) {
        int i = hash(key);
            arr[i] = -1;
    }
}
