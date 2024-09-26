// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
 Creating two stacks 

   Class Solution {
           
Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<Integer>();
        s2=new Stack<Integer>();
    }
    
    // Push element x to the back of queue
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.add(s1.pop());
    }
    s1.add(x);
    while(!s2.isEmpty())
    {
        s1.add(s2.pop());
    
    }
    }
    // Removes the element from in front of queue and returns that element
    public int pop() {
        return s1.pop();
    }
    
    // Get the front element
    public int peek() {
        if(!s1.isEmpty())
        return s1.peek();
        return -1;
    }
    
    // Returns whether the queue is empty
    public boolean empty() {
        return s1.isEmpty();
    }
}







//Time complexity is O(N/K)  N = keys K = buckets
//space cpmplexity is O(K+M) is the k = bucket M = unique keys to keep in the hashmap



   Class HashMap {

    int[] arr;
    public HashMap() {
     arr = new int[1000000];
     Arrays.fill(arr, -1);
   }

 
  public void put (int key, int val) {
    arr[key] = val;
  }


  public int get (int key) {

      return arr[key];
  }
  public void remove(int key) {
  arr[key] = -1;
  }

}



  
    



