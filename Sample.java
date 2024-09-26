// Time Complexity :O(1)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Problem 1
class MinStack {
    private Stack<Integer> st;
    private int min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;    
    }
    
    public void push(int val) {
        if(val <= min){
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(min == st.pop()){
            min = st.pop();
        }
        
    }
    
    public int top() {
       return st.peek(); 
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 //Problem 2
 / Time Complexity :O(1)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : i am unable to run the code in leetcode
// Any problem you faced while coding this :i am unable to keep a track on logic for this problem only

public class MyHashset {
	private boolean [][] arstorage;
	
	private int buckets;
	
	private int bucketitems;

    public void MyHashSet() 
    {
        buckets = 1000;
    	bucketitems =1000;
        arstorage = new boolean[buckets][];
    }
    public int bucket(int key) {
    	return key%buckets;
    }
    public int bucketitem(int key) {
    	return key / bucketitems;
    }
	public void add(int key) {
    	int bucket = bucket(key);
    	int bucketitem = bucketitem(key);
    	if(arstorage[bucket] == null) {
    		if(bucket == 0) {
    			arstorage[bucket] = new boolean[bucketitems+1];
    		}else {
    			arstorage[bucket] = new boolean[bucketitems];
    		}
    	}
    	arstorage[bucket][bucketitem] = true;
    }
    
    public void remove(int key) {
    	int bucket = bucket(key);
    	int bucketitem = bucketitem(key);
    	if(arstorage[bucket] == null)
    		return;
    	arstorage[bucket][bucketitems] = false;
  
    }
    
    public boolean contains(int key) {
    	int bucket = bucket(key);
    	int bucketitem = bucketitem(key);
    	if(arstorage[bucket] == null)
		return false;
    	return arstorage[bucket][bucketitem];
    	
}

}




/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */